#!/usr/bin/env python3
"""
a3_table.py -- Assignment 3 pilot table, from the raw EvoMaster output only.

Usage:
    python3 scripts/a3_table.py [ROOT]          (default ROOT: raw/a3)

Reads ROOT/<variant>/<case>/run_<i>/ (report.json, statistics.csv,
evomaster_stdout.log, run_meta.txt, generated tests) and writes:

    derived/a3_runs.csv       one row per run: outcome, reported endpoints,
                              TP/FP/FN against the expected results, costs
    derived/a3_results.csv    one row per case x variant (aggregated)
    derived/a3_summary.md     the pilot tables (printed as well)

Definitions (also in the report, Q4):
  - A run's "confirmed" set: endpoints (report.json operationId, e.g.
    POST:/api/resources/) with fault code 305 (Not-Recognized) in at least
    one generated test. Several tests on one endpoint count once.
  - "unconfirmed" set: endpoints with code 950 (the prototype's low-confidence
    category) and no 305 in that run.
  - TP/FP/FN compare the confirmed set with the case's expected set (EXPECTED
    below, from cases/README.md, established by construction and replays).
  - Only runs with exit status 0 and a report.json are scored ("ok"); other
    runs are listed with their outcome and not scored.
  - Costs: "Phase SECURITY lasted" from evomaster_stdout.log (1 s resolution);
    evaluatedActions (HTTP calls in the whole run) and elapsedSeconds from
    statistics.csv; replay calls from the prototype's log line
    "Not-Recognized confirmation (A3): ... replayCalls=N".
  - "other faults": statistics.csv potentialFaultsSummary without codes 305
    and 950, to check that the other oracles are unchanged.

Standard library only.
"""

import csv
import glob
import json
import os
import re
import statistics
import sys
from collections import Counter, defaultdict

REPO_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

NOT_RECOGNIZED = 305
UNCONFIRMED = 950

# Expected Not-Recognized faults per case (endpoint operationIds), independent
# of EvoMaster: see cases/README.md and scripts/a3_replays.sh / a2_replays.sh.
EXPECTED = {
    "K": {"POST:/api/resources/"},
    "H1": set(),
    "H1c": {"POST:/api/vault"},
    "H2": {"DELETE:/api/admin/cache"},
    "H4": set(),
    "P": set(),
    "C-alt": set(),
}

ROLES = {
    "P": "primary (A2 failed case)",
    "C-alt": "matched control of P (A2)",
    "H1": "variant: second credential",
    "H1c": "matched control of H1",
    "K": "regression (A2 known example)",
    "H2": "tradeoff: role-restricted",
    "H4": "Rule 1 case: misconfigured user",
}

CASE_ORDER = ["P", "C-alt", "H1", "H1c", "K", "H2", "H4"]
VARIANT_ORDER = ["baseline", "proto", "rule1", "rule2", "forkoff"]

PHASE_RE = re.compile(r"Phase (\w+) lasted: (\d+)h (\d+)m (\d+)s")
A3_RE = re.compile(r"Not-Recognized confirmation \(A3\):.*?constructedTests=(\d+) replayCalls=(\d+)"
                   r" confirmedTests=(\d+) unconfirmedTests=(\d+)")
TEST_HEADER_RE = re.compile(r"/\*\*\s*\n\s*\* Calls:\n(.*?)\*/\s*@Test[^\n]*\n\s*fun (\w+)", re.S)


def short(op):
    return op.replace("/WebGoat", "")


def fmt_set(ops):
    return "; ".join(sorted(short(o) for o in ops)) or "none"


def read_kv(path):
    out = {}
    if os.path.isfile(path):
        with open(path) as f:
            for line in f:
                if ":" in line:
                    k, v = line.split(":", 1)
                    out[k.strip()] = v.strip()
    return out


def read_stats(run_dir):
    path = os.path.join(run_dir, "statistics.csv")
    if not os.path.isfile(path):
        return {}
    with open(path, newline="") as f:
        return next(csv.DictReader(f), {}) or {}


def fault_ops(run_dir):
    """{code: set(operationId)} from report.json, or None if missing."""
    path = os.path.join(run_dir, "report.json")
    if not os.path.isfile(path):
        return None
    with open(path) as f:
        report = json.load(f)
    ops = defaultdict(set)
    for fault in report["faults"]["foundFaults"]:
        for cat in fault["faultCategories"]:
            ops[int(cat["code"])].add(fault["operationId"])
    return ops


def log_info(run_dir):
    phases, a3 = {}, None
    path = os.path.join(run_dir, "evomaster_stdout.log")
    if os.path.isfile(path):
        with open(path, errors="ignore") as f:
            text = f.read()
        for name, h, m, s in PHASE_RE.findall(text):
            phases[name] = int(h) * 3600 + int(m) * 60 + int(s)
        found = A3_RE.findall(text)
        if found:
            a3 = tuple(int(x) for x in found[-1])
    return phases, a3


def other_faults(stats):
    summary = stats.get("potentialFaultsSummary", "") or ""
    parts = [p for p in summary.split("|") if p and p.split(":")[0] not in (str(NOT_RECOGNIZED), str(UNCONFIRMED))]
    return "|".join(parts)


def nr_sequences(run_dir):
    """Call sequences ('Calls:' headers) of the generated tests with 305 or 950."""
    out = []
    for f in sorted(glob.glob(os.path.join(run_dir, "EvoMaster_*_Test.kt"))):
        with open(f, errors="ignore") as fh:
            content = fh.read()
        for m in TEST_HEADER_RE.finditer(content):
            header = m.group(1)
            codes = set(re.findall(r"\b(\d{3})\b", " ".join(
                line for line in header.splitlines() if "type-code" in line.lower())))
            if codes & {str(NOT_RECOGNIZED), str(UNCONFIRMED)}:
                calls = [line.strip(" *") for line in header.splitlines()
                         if re.match(r"\s*\*\s*(\d+ - )?\(\d{3}\)", line)]
                out.append((os.path.basename(f), m.group(2), sorted(codes), calls))
    return out


def run_rows(root):
    rows = []
    for variant_dir in sorted(glob.glob(os.path.join(root, "*"))):
        variant = os.path.basename(variant_dir)
        if variant not in VARIANT_ORDER:
            continue
        for case_dir in sorted(glob.glob(os.path.join(variant_dir, "*"))):
            case = os.path.basename(case_dir)
            if case not in EXPECTED:
                continue
            env = read_kv(os.path.join(case_dir, "environment.txt"))
            budget = env.get("max_time", "")
            for run_dir in sorted(glob.glob(os.path.join(case_dir, "run_*")),
                                  key=lambda p: int(p.rsplit("_", 1)[1])):
                meta = read_kv(os.path.join(run_dir, "run_meta.txt"))
                stats = read_stats(run_dir)
                ops = fault_ops(run_dir)
                phases, a3 = log_info(run_dir)
                exit_status = meta.get("exit_status", "")
                if exit_status == "0" and ops is not None:
                    outcome = "ok"
                elif exit_status == "" and ops is not None:
                    # runs from before run_meta.txt existed (A2); report.json is
                    # written at the end of a completed run
                    outcome = "ok"
                elif exit_status == "":
                    outcome = "incomplete (no run_meta.txt, no report.json)"
                else:
                    outcome = f"failed (exit {exit_status}{', no report.json' if ops is None else ''})"
                row = {
                    "variant": variant, "case": case, "run": run_dir.rsplit("_", 1)[1],
                    "seed": meta.get("seed", ""), "budget": budget,
                    "start_utc": meta.get("start_utc", ""), "end_utc": meta.get("end_utc", ""),
                    "exit_status": exit_status, "outcome": outcome,
                    "image": env.get("evomaster_image", ""),
                    "extra_args": env.get("extra_args", ""),
                }
                expected = EXPECTED[case]
                if outcome == "ok":
                    confirmed = ops.get(NOT_RECOGNIZED, set())
                    unconfirmed = ops.get(UNCONFIRMED, set()) - confirmed
                    row.update({
                        "confirmed": fmt_set(confirmed), "unconfirmed": fmt_set(unconfirmed),
                        "n_confirmed": len(confirmed), "n_unconfirmed": len(unconfirmed),
                        "tp": len(confirmed & expected), "fp": len(confirmed - expected),
                        "fn": len(expected - confirmed),
                    })
                    row["_confirmed"], row["_unconfirmed"] = confirmed, unconfirmed
                row.update({
                    "security_s": phases.get("SECURITY", ""),
                    "search_s": phases.get("SEARCH", ""),
                    "elapsed_s": stats.get("elapsedSeconds", ""),
                    "evaluated_actions": stats.get("evaluatedActions", ""),
                    "covered2xx": stats.get("covered2xx", ""),
                    "a3_constructed_tests": a3[0] if a3 else "",
                    "a3_replay_calls": a3[1] if a3 else "",
                    "a3_confirmed_tests": a3[2] if a3 else "",
                    "a3_unconfirmed_tests": a3[3] if a3 else "",
                    "other_faults": other_faults(stats),
                })
                row["_dir"] = run_dir
                rows.append(row)
    return rows


def med(values):
    vals = [float(v) for v in values if v not in ("", None)]
    if not vals:
        return ""
    m = statistics.median(vals)
    return f"{m:.0f}" if m == int(m) else f"{m:.1f}"


def rng(values):
    vals = [float(v) for v in values if v not in ("", None)]
    if not vals:
        return ""
    return f"{min(vals):.0f}-{max(vals):.0f}"


def counted(sets, n):
    c = Counter(op for s in sets for op in s)
    return "; ".join(f"{short(op)} ({k}/{n})" for op, k in sorted(c.items())) or "none"


def aggregate(rows):
    groups = defaultdict(list)
    for r in rows:
        groups[(r["case"], r["variant"])].append(r)
    out = []
    for case in CASE_ORDER:
        for variant in VARIANT_ORDER:
            rs = groups.get((case, variant))
            if not rs:
                continue
            ok = [r for r in rs if r["outcome"] == "ok"]
            tp = sum(r["tp"] for r in ok)
            fp = sum(r["fp"] for r in ok)
            fn = sum(r["fn"] for r in ok)
            others = sorted({r["other_faults"] for r in ok})
            out.append({
                "case": case, "role": ROLES[case], "variant": variant,
                "budget": rs[0]["budget"], "runs_ok": f"{len(ok)}/{len(rs)}",
                "expected": fmt_set(EXPECTED[case]),
                "confirmed_305": counted([r["_confirmed"] for r in ok], len(ok)),
                "unconfirmed_950": counted([r["_unconfirmed"] for r in ok], len(ok)),
                "tp": tp, "fp": fp, "fn": fn,
                "precision": f"{tp / (tp + fp):.2f}" if tp + fp else "n/a",
                "recall": f"{tp / (tp + fn):.2f}" if tp + fn else "n/a",
                "security_s_median": med(r["security_s"] for r in rs),
                "security_s_range": rng(r["security_s"] for r in rs),
                "replay_calls_median": med(r["a3_replay_calls"] for r in rs),
                "constructed_tests_median": med(r["a3_constructed_tests"] for r in rs),
                "evaluated_actions_median": med(r["evaluated_actions"] for r in rs),
                "elapsed_s_median": med(r["elapsed_s"] for r in rs),
                "other_faults_distinct": " / ".join(others) if others else "",
                "failed_runs": "; ".join(f"run {r['run']}: {r['outcome']}" for r in rs if r["outcome"] != "ok"),
            })
    return out


def write_csv(path, rows, fields):
    with open(path, "w", newline="") as f:
        w = csv.DictWriter(f, fieldnames=fields, extrasaction="ignore")
        w.writeheader()
        for r in rows:
            w.writerow(r)


def main():
    root = sys.argv[1] if len(sys.argv) > 1 else os.path.join(REPO_ROOT, "raw", "a3")
    rows = run_rows(root)
    if not rows:
        print(f"no runs found under {root}")
        return 1
    agg = aggregate(rows)

    derived = os.path.join(REPO_ROOT, "derived")
    os.makedirs(derived, exist_ok=True)
    run_fields = ["variant", "case", "run", "seed", "budget", "start_utc", "end_utc", "exit_status",
                  "outcome", "confirmed", "unconfirmed", "n_confirmed", "n_unconfirmed", "tp", "fp", "fn",
                  "security_s", "search_s", "elapsed_s", "evaluated_actions", "covered2xx",
                  "a3_constructed_tests", "a3_replay_calls", "a3_confirmed_tests", "a3_unconfirmed_tests",
                  "other_faults", "image", "extra_args"]
    agg_fields = list(agg[0].keys())
    suffix = "" if os.path.abspath(root) == os.path.join(REPO_ROOT, "raw", "a3") else "_" + os.path.basename(os.path.normpath(root))
    write_csv(os.path.join(derived, f"a3_runs{suffix}.csv"), rows, run_fields)
    write_csv(os.path.join(derived, f"a3_results{suffix}.csv"), agg, agg_fields)

    lines = [f"# A3 pilot results ({os.path.relpath(root, REPO_ROOT)})", "",
             "Generated by `scripts/a3_table.py`; definitions in its docstring and in report.md Q4.",
             "Confirmed = endpoints with code 305; unconfirmed = code 950 only. (k/n) = in k of n scored runs.", "",
             "## Not-Recognized reports per case and configuration", "",
             "| Case | Role | Config | Budget | Runs ok | Expected | Confirmed (305) | Unconfirmed (950) | TP/FP/FN | Precision | Recall |",
             "|---|---|---|---|---|---|---|---|---|---|---|"]
    for a in agg:
        lines.append(f"| {a['case']} | {a['role']} | {a['variant']} | {a['budget']} | {a['runs_ok']} | {a['expected']} | "
                     f"{a['confirmed_305']} | {a['unconfirmed_950']} | {a['tp']}/{a['fp']}/{a['fn']} | "
                     f"{a['precision']} | {a['recall']} |")
    lines += ["", "## Cost (medians over runs; security phase range in brackets)", "",
              "| Case | Config | Security phase s | Replay calls | Constructed NR tests | HTTP calls (evaluatedActions) | Elapsed s | Other faults (codes:count) |",
              "|---|---|---|---|---|---|---|---|"]
    for a in agg:
        lines.append(f"| {a['case']} | {a['variant']} | {a['security_s_median']} [{a['security_s_range']}] | "
                     f"{a['replay_calls_median'] or '-'} | {a['constructed_tests_median'] or '-'} | "
                     f"{a['evaluated_actions_median']} | {a['elapsed_s_median']} | {a['other_faults_distinct'].replace('|', ', ')} |")
    failed = [a for a in agg if a["failed_runs"]]
    lines += ["", "## Unsuccessful runs", ""]
    lines += [f"- {a['case']} / {a['variant']}: {a['failed_runs']}" for a in failed] or ["None."]

    lines += ["", "## Call sequences of the Not-Recognized tests (run 1 of each case and configuration)", "",
              "Status codes and endpoints from the generated tests' `Calls:` headers. The prototype's replays are the",
              "last calls of each test (Rule 1: Y without credentials; Rule 2: X as the other user).", ""]
    for case in CASE_ORDER:
        for variant in VARIANT_ORDER:
            first = [r for r in rows if r["case"] == case and r["variant"] == variant and r["run"] == "1"]
            if not first or first[0]["outcome"] != "ok":
                continue
            seqs = nr_sequences(first[0]["_dir"])
            lines.append(f"### {case} / {variant}")
            lines.append("")
            if not seqs:
                lines += ["No test with code 305 or 950.", ""]
                continue
            for fname, test, codes, calls in seqs:
                tag = "305" if "305" in codes else "950"
                lines.append(f"- `{fname}` `{test}` ({tag}): " + " → ".join(short(c) for c in calls))
            lines.append("")

    text = "\n".join(lines) + "\n"
    with open(os.path.join(derived, f"a3_summary{suffix}.md"), "w") as f:
        f.write(text)
    print(text)
    return 0


if __name__ == "__main__":
    sys.exit(main())
