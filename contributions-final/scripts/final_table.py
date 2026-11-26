#!/usr/bin/env python3
"""
final_table.py -- final-project results tables, from the raw EvoMaster output only.

Usage:
    python3 scripts/final_table.py [ROOT ...]      (default ROOT: raw/final)

Reads ROOT/<variant>/<case>/run_<i>/ for every ROOT (same layout as A3, see
a3_table.py) and, for the WebGoat full-API baseline, A1's raw/webgoat/run_<i>/
(official image, 1 h, seeds 1-10; notes/final_decisions.md D5), reported as
variant "baseline_A1". Writes:

    derived/final_runs.csv      one row per run: outcome, reported endpoints, TP/FP/FN, costs
    derived/final_results.csv   one row per case x variant
    derived/final_scaling.csv   one row per scaling cell (E, U) x variant
    derived/final_summary.md    the tables (printed as well)

Definitions are a3_table.py's (confirmed = code 305 on the endpoint in the
run; unconfirmed = 950 only; only runs with exit status 0 and a report.json
are scored), plus:
  - Labels: H5-H8 by construction (notes/final_predictions.md, checked by
    scripts/final_replays.sh); scaling cells from cases/final_scaling/*/labels.json;
    crAPI and the WebGoat full API from notes/final_labels.csv (case, operation,
    label in {fault, no_fault}), written after reading the source and replaying.
    A reported endpoint without a label counts as "unknown": it is listed, and
    precision is computed over labelled endpoints only, with the number of
    unknown ones shown next to it.
  - Recall needs the full set of true faults. For crAPI and WebGoat it is the
    set of endpoints labelled "fault" (found by any configuration), so it is
    relative recall, not absolute.
  - Cost of the Not-Recognized step: the final image's log line
    "Not-Recognized step cost (final): ... elapsedMs=N evaluatedTests=N
    evaluatedCalls=N" (proto, rule1, rule2, forkoff; not the official image).

Standard library only.
"""

import csv
import glob
import json
import os
import re
import sys
from collections import defaultdict

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import a3_table as a3  # noqa: E402  (reuse the A3 parsing helpers)

REPO_ROOT = a3.REPO_ROOT
NR, UNC = a3.NOT_RECOGNIZED, a3.UNCONFIRMED

FIXED_EXPECTED = {
    "H5": set(),
    "H6": {"GET:/api/billing"},
    "H7": {"GET:/api/export"},
    "H8": {"DELETE:/api/admin/cache"},
}
ROLES = {
    "H5": "held-out: second scheme (WWW-Authenticate)",
    "H6": "held-out: redirect login, true fault",
    "H7": "held-out: evidence through a creating POST",
    "H8": "held-out: three users, two denied",
    "crapi": "held-out real API (crAPI v1.1.6)",
    "wgfull": "WebGoat full API, 1 h",
}
CASE_ORDER = ["H5", "H6", "H7", "H8", "crapi", "wgfull"]
VARIANT_ORDER = a3.VARIANT_ORDER
SCALE_RE = re.compile(r"^S(\d+)x(\d+)$")
COST_RE = re.compile(r"Not-Recognized step cost \(final\): rulesEnabled=(\w+) elapsedMs=(\d+)"
                     r" evaluatedTests=(\d+) evaluatedCalls=(\d+) timedOut=(\w+)")
WG_BASELINE_DIR = os.path.join(REPO_ROOT, "raw", "webgoat")


def read_labels():
    """{case: {operation: label}} from notes/final_labels.csv (if present)."""
    out = defaultdict(dict)
    path = os.path.join(REPO_ROOT, "notes", "final_labels.csv")
    if os.path.isfile(path):
        with open(path, newline="") as f:
            for row in csv.DictReader(f):
                out[row["case"]][row["operation"]] = row["label"].strip()
    return out


def scaling_labels(e, u):
    path = os.path.join(REPO_ROOT, "cases", "final_scaling", f"E{e}_U{u}", "labels.json")
    with open(path) as f:
        lab = json.load(f)
    return {ep["operation"]: ("fault" if ep["kind"] == "true" else "no_fault") for ep in lab["endpoints"]}


def labels_for(case, labels):
    """{operation: 'fault' | 'no_fault'} for the case; unlisted operations are unknown."""
    if case in FIXED_EXPECTED:
        return {op: "fault" for op in FIXED_EXPECTED[case]}, True  # every other endpoint: no fault
    m = SCALE_RE.match(case)
    if m:
        return scaling_labels(int(m.group(1)), int(m.group(2))), True
    return labels.get(case, {}), False


def cost_info(run_dir):
    path = os.path.join(run_dir, "evomaster_stdout.log")
    if not os.path.isfile(path):
        return None
    with open(path, errors="ignore") as f:
        found = COST_RE.findall(f.read())
    if not found:
        return None
    rules, ms, tests, calls, timed_out = found[-1]
    return {"nr_step_ms": int(ms), "nr_eval_tests": int(tests), "nr_eval_calls": int(calls),
            "nr_timed_out": timed_out}


def score(row, case, labels):
    lab, closed = labels_for(case, labels)
    confirmed, unconfirmed = row["_confirmed"], row["_unconfirmed"]
    faults = {op for op, v in lab.items() if v == "fault"}
    if closed:
        known_fp = confirmed - faults
        unknown = set()
    else:
        known_fp = {op for op in confirmed if lab.get(op) == "no_fault"}
        unknown = {op for op in confirmed | unconfirmed if op not in lab}
    row.update({
        "tp": len(confirmed & faults), "fp": len(known_fp), "fn": len(faults - confirmed),
        "unknown": len(unknown), "_unknown": unknown,
        "unconfirmed_faults": len(unconfirmed & faults),  # true faults only in 950: what a human would still see
    })


def collect(root, rows, labels):
    for variant_dir in sorted(glob.glob(os.path.join(root, "*"))):
        variant = os.path.basename(variant_dir)
        if variant not in VARIANT_ORDER:
            continue
        for case_dir in sorted(glob.glob(os.path.join(variant_dir, "*"))):
            case = os.path.basename(case_dir)
            if case not in CASE_ORDER and not SCALE_RE.match(case):
                continue
            add_case_runs(case_dir, variant, case, rows, labels, root)


def add_case_runs(case_dir, variant, case, rows, labels, root):
    env = a3.read_kv(os.path.join(case_dir, "environment.txt"))
    for run_dir in sorted(glob.glob(os.path.join(case_dir, "run_*")), key=lambda p: int(p.rsplit("_", 1)[1])):
        meta = a3.read_kv(os.path.join(run_dir, "run_meta.txt"))
        stats = a3.read_stats(run_dir)
        ops = a3.fault_ops(run_dir)
        phases, a3info = a3.log_info(run_dir)
        exit_status = meta.get("exit_status", "")
        if ops is not None and exit_status in ("0", ""):
            outcome = "ok"
        elif ops is None and exit_status == "":
            outcome = "incomplete (no run_meta.txt, no report.json)"
        else:
            outcome = f"failed (exit {exit_status}{', no report.json' if ops is None else ''})"
        row = {"root": os.path.relpath(root, REPO_ROOT), "variant": variant, "case": case,
               "run": run_dir.rsplit("_", 1)[1], "seed": meta.get("seed", run_dir.rsplit("_", 1)[1]),
               "budget": env.get("max_time", ""), "start_utc": meta.get("start_utc", ""),
               "end_utc": meta.get("end_utc", ""), "exit_status": exit_status, "outcome": outcome,
               "image": env.get("evomaster_image", ""), "extra_args": env.get("extra_args", "")}
        m = SCALE_RE.match(case)
        row["E"], row["U"] = (m.group(1), m.group(2)) if m else ("", "")
        if outcome == "ok":
            confirmed = ops.get(NR, set())
            unconfirmed = ops.get(UNC, set()) - confirmed
            row.update({"_confirmed": confirmed, "_unconfirmed": unconfirmed,
                        "confirmed": a3.fmt_set(confirmed), "unconfirmed": a3.fmt_set(unconfirmed),
                        "n_confirmed": len(confirmed), "n_unconfirmed": len(unconfirmed)})
            score(row, case, labels)
        cost = cost_info(run_dir) or {}
        row.update({
            "security_s": phases.get("SECURITY", ""), "elapsed_s": stats.get("elapsedSeconds", ""),
            "evaluated_actions": stats.get("evaluatedActions", ""), "covered2xx": stats.get("covered2xx", ""),
            "constructed_tests": a3info[0] if a3info else "", "replay_calls": a3info[1] if a3info else "",
            "nr_step_ms": cost.get("nr_step_ms", ""), "nr_eval_tests": cost.get("nr_eval_tests", ""),
            "nr_eval_calls": cost.get("nr_eval_calls", ""), "nr_timed_out": cost.get("nr_timed_out", ""),
            "other_faults": a3.other_faults(stats), "_dir": run_dir,
        })
        rows.append(row)


def prf(tp, fp, fn):
    p = f"{tp / (tp + fp):.2f}" if tp + fp else "n/a"
    r = f"{tp / (tp + fn):.2f}" if tp + fn else "n/a"
    return p, r


def aggregate(rows, keyf, order):
    groups = defaultdict(list)
    for r in rows:
        groups[keyf(r)].append(r)
    out = []
    for key in sorted(groups, key=order):
        rs = groups[key]
        ok = [r for r in rs if r["outcome"] == "ok"]
        tp, fp, fn = (sum(r[k] for r in ok) for k in ("tp", "fp", "fn"))
        p, rec = prf(tp, fp, fn)
        unknown = set().union(*[r["_unknown"] for r in ok]) if ok else set()
        out.append({
            "key": key, "variant": rs[0]["variant"], "case": rs[0]["case"], "E": rs[0]["E"], "U": rs[0]["U"],
            "budget": rs[0]["budget"], "runs_ok": f"{len(ok)}/{len(rs)}",
            "confirmed_305": a3.counted([r["_confirmed"] for r in ok], len(ok)),
            "unconfirmed_950": a3.counted([r["_unconfirmed"] for r in ok], len(ok)),
            "tp": tp, "fp": fp, "fn": fn, "precision": p, "recall": rec,
            "unknown_endpoints": a3.fmt_set(unknown) if unknown else "",
            "true_faults_only_950": sum(r["unconfirmed_faults"] for r in ok),
            "replay_calls_median": a3.med(r["replay_calls"] for r in rs),
            "constructed_tests_median": a3.med(r["constructed_tests"] for r in rs),
            "nr_step_ms_median": a3.med(r["nr_step_ms"] for r in rs),
            "nr_step_ms_range": a3.rng(r["nr_step_ms"] for r in rs),
            "nr_eval_calls_median": a3.med(r["nr_eval_calls"] for r in rs),
            "security_s_median": a3.med(r["security_s"] for r in rs),
            "evaluated_actions_median": a3.med(r["evaluated_actions"] for r in rs),
            "covered2xx_median": a3.med(r["covered2xx"] for r in rs),
            "failed_runs": "; ".join(f"run {r['run']}: {r['outcome']}" for r in rs if r["outcome"] != "ok"),
        })
    return out


def main():
    roots = sys.argv[1:] or [os.path.join(REPO_ROOT, "raw", "final")]
    labels = read_labels()
    rows = []
    for root in roots:
        collect(root, rows, labels)
    if any(r["case"] == "wgfull" for r in rows) and os.path.isdir(WG_BASELINE_DIR):
        # kept apart from fresh baseline runs (raw/final/baseline/wgfull), if any
        add_case_runs(WG_BASELINE_DIR, "baseline_A1", "wgfull", rows, labels, WG_BASELINE_DIR)
    if not rows:
        print(f"no runs found under {', '.join(roots)}")
        return 1

    vorder = {v: i for i, v in enumerate(["baseline_A1"] + VARIANT_ORDER)}
    corder = {c: i for i, c in enumerate(CASE_ORDER)}
    cases = [r for r in rows if not r["E"]]
    scale = [r for r in rows if r["E"]]
    agg = aggregate(cases, lambda r: (r["case"], r["variant"]),
                    lambda k: (corder.get(k[0], 99), vorder.get(k[1], 99)))
    sagg = aggregate(scale, lambda r: (int(r["E"]), int(r["U"]), r["variant"]),
                     lambda k: (k[0], k[1], vorder.get(k[2], 99)))

    derived = os.path.join(REPO_ROOT, "derived")
    os.makedirs(derived, exist_ok=True)
    run_fields = ["root", "variant", "case", "E", "U", "run", "seed", "budget", "start_utc", "end_utc",
                  "exit_status", "outcome", "confirmed", "unconfirmed", "n_confirmed", "n_unconfirmed",
                  "tp", "fp", "fn", "unknown", "unconfirmed_faults", "security_s", "elapsed_s",
                  "evaluated_actions", "covered2xx", "constructed_tests", "replay_calls", "nr_step_ms",
                  "nr_eval_tests", "nr_eval_calls", "nr_timed_out", "other_faults", "image", "extra_args"]
    agg_fields = [k for k in (agg or sagg)[0].keys() if k != "key"]
    a3.write_csv(os.path.join(derived, "final_runs.csv"), rows, run_fields)
    if agg:
        a3.write_csv(os.path.join(derived, "final_results.csv"), agg, agg_fields)
    if sagg:
        a3.write_csv(os.path.join(derived, "final_scaling.csv"), sagg, agg_fields)

    L = ["# Final project results", "",
         f"Generated by `scripts/final_table.py` from {', '.join(os.path.relpath(r, REPO_ROOT) for r in roots)}"
         + (" and A1's `raw/webgoat` (WebGoat baseline)." if any(r["case"] == "wgfull" for r in rows) else "."),
         "Confirmed = endpoints with code 305; unconfirmed = 950 only; (k/n) = in k of n scored runs.",
         "Precision over labelled endpoints; \"unknown\" = reported endpoints without a label yet.", ""]
    if agg:
        L += ["## Cases", "",
              "| Case | Role | Config | Budget | Runs ok | Confirmed (305) | Unconfirmed (950) | TP/FP/FN | Precision | Recall | Unknown |",
              "|---|---|---|---|---|---|---|---|---|---|---|"]
        for a in agg:
            L.append(f"| {a['case']} | {ROLES.get(a['case'], '')} | {a['variant']} | {a['budget']} | {a['runs_ok']} | "
                     f"{a['confirmed_305']} | {a['unconfirmed_950']} | {a['tp']}/{a['fp']}/{a['fn']} | "
                     f"{a['precision']} | {a['recall']} | {a['unknown_endpoints'] or '-'} |")
        L += ["", "## Cost per case (medians over runs)", "",
              "| Case | Config | NR step ms [range] | NR step HTTP calls | Replay calls | Constructed NR tests | Security phase s | HTTP calls in run | Endpoints with 2xx |",
              "|---|---|---|---|---|---|---|---|---|"]
        for a in agg:
            L.append(f"| {a['case']} | {a['variant']} | {a['nr_step_ms_median'] or '-'} [{a['nr_step_ms_range']}] | "
                     f"{a['nr_eval_calls_median'] or '-'} | {a['replay_calls_median'] or '-'} | "
                     f"{a['constructed_tests_median'] or '-'} | {a['security_s_median']} | "
                     f"{a['evaluated_actions_median']} | {a['covered2xx_median']} |")
    if sagg:
        L += ["", "## Scaling grid (generated API; medians over runs, TP/FP/FN pooled)", "",
              "| E | U | Config | Runs ok | TP/FP/FN | Precision | Recall | NR step ms [range] | NR step HTTP calls | Replay calls | Constructed NR tests | HTTP calls in run |",
              "|---|---|---|---|---|---|---|---|---|---|---|---|"]
        for a in sagg:
            L.append(f"| {a['E']} | {a['U']} | {a['variant']} | {a['runs_ok']} | {a['tp']}/{a['fp']}/{a['fn']} | "
                     f"{a['precision']} | {a['recall']} | {a['nr_step_ms_median'] or '-'} [{a['nr_step_ms_range']}] | "
                     f"{a['nr_eval_calls_median'] or '-'} | {a['replay_calls_median'] or '-'} | "
                     f"{a['constructed_tests_median'] or '-'} | {a['evaluated_actions_median']} |")
    failed = [a for a in agg + sagg if a["failed_runs"]]
    L += ["", "## Unsuccessful runs", ""]
    L += [f"- {a['case']} / {a['variant']}: {a['failed_runs']}" for a in failed] or ["None."]

    L += ["", "## Call sequences of the Not-Recognized tests (run 1 of each case and configuration)", ""]
    for a in agg:
        first = [r for r in cases if r["case"] == a["case"] and r["variant"] == a["variant"] and r["run"] == "1"]
        if not first or first[0]["outcome"] != "ok":
            continue
        seqs = a3.nr_sequences(first[0]["_dir"])
        L += [f"### {a['case']} / {a['variant']}", ""]
        if not seqs:
            L += ["No test with code 305 or 950.", ""]
            continue
        for fname, test, codes, calls in seqs[:20]:
            tag = "305" if "305" in codes else "950"
            L.append(f"- `{fname}` `{test}` ({tag}): " + " → ".join(a3.short(c) for c in calls))
        if len(seqs) > 20:
            L.append(f"- ... {len(seqs) - 20} more")
        L.append("")

    text = "\n".join(L) + "\n"
    with open(os.path.join(derived, "final_summary.md"), "w") as f:
        f.write(text)
    print(text)
    return 0


if __name__ == "__main__":
    sys.exit(main())
