#!/usr/bin/env python3
"""
a2_table.py

Builds the Assignment 2 results table (case index: cases/README.md) from the
raw EvoMaster output under raw/a2/ and the replays under
raw/a2/replays/.

For every run of every case it lists the endpoints EvoMaster reported as
Not-Recognized, compares them with the expected behavior (ground truth) and
with the prediction committed in notes/a2_predictions.md, and writes:

    derived/a2_results.csv       one row per case per run
    derived/a2_summary.md        per-case summary, replays, run index, evidence
                                 analysis (also printed)
    derived/a2_run_index.csv     run ID, seed, config, start/end time, exit status
    derived/a2_evidence.csv      one row per generated test that shows a
                                 Not-Recognized fault: its calls, users, and
                                 what differs between the evidence calls
    derived/a2_call_statuses.csv status codes per JWT endpoint and caller

Not-Recognized faults are identified by their description in the generated
tests, using the same matching as extract_metrics.py, so the EvoMaster fault
code number does not matter.

Usage:
    python3 scripts/a2_table.py                  # reads raw/a2/
    python3 scripts/a2_table.py raw/a2_pilot # any folder with case subfolders
    python3 scripts/a2_table.py --calls raw/a2/C/run_1
        # status codes observed for the JWT endpoints in one run (pilot check)
    python3 scripts/a2_table.py --vote-accepted raw/a2_pilot/C/run_1
        # exit 0 if some POST /JWT/votings/{title} call returned 202, i.e. the
        # extra access_token cookie reached WebGoat (control C decision rule)
"""

import csv
import glob
import json
import os
import re
import sys
from collections import Counter, defaultdict

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from extract_metrics import classify, read_fault_comments, run_number  # noqa: E402

REPO_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

VOTE = "POST:/WebGoat/JWT/votings/{title}"
VOTE_LOGIN = "GET:/WebGoat/JWT/votings/login"
REFRESH_LOGIN = "POST:/WebGoat/JWT/refresh/login"
NEW_TOKEN = "POST:/WebGoat/JWT/refresh/newToken"
CHECKOUT = "POST:/WebGoat/JWT/refresh/checkout"
BASELINE_FIVE = {VOTE_LOGIN, VOTE, REFRESH_LOGIN, NEW_TOKEN, CHECKOUT}
K_FAULT = "POST:/api/resources/"

WEBGOAT_BASIS = ("WebGoat JWT lesson source (cases/P_webgoat_jwt/README.md), "
                 "RFC 9110 15.5.2, replays R1-R6")

# Case definitions: notes/a2_predictions.md and cases/README.md.
CASES = [
    {
        "id": "K", "role": "Known working example",
        "setup": "Case K app (port of EvoMaster's NotRecognizedApplication); users FOO, BAR",
        "expected": {K_FAULT},
        "basis": "By construction; EvoMaster's own end-to-end test for this oracle; replays R7a-c",
        "predicted": {K_FAULT},
    },
    {
        "id": "P", "role": "Primary failed case",
        "setup": "WebGoat, --endpointPrefix /JWT, webgoat-em.yaml",
        "expected": set(), "basis": WEBGOAT_BASIS,
        "predicted": set(BASELINE_FIVE),
    },
    {
        "id": "C", "role": "Matched control (cookie)",
        "setup": "As P, users also send Cookie: access_token (lesson user Tom)",
        "expected": set(), "basis": WEBGOAT_BASIS + ", R4",
        "predicted": BASELINE_FIVE - {VOTE},
    },
    {
        "id": "C-alt", "role": "Matched control (Authorization header)",
        "setup": "As P, users also send Authorization: Bearer a2-control",
        "expected": set(), "basis": WEBGOAT_BASIS + ", R6b",
        "predicted": BASELINE_FIVE - {CHECKOUT},
    },
    {
        "id": "V", "role": "Additional variant",
        "setup": "As P, plus --endpointExclude /JWT/votings/login",
        "expected": set(), "basis": WEBGOAT_BASIS,
        "predicted": {CHECKOUT},
    },
    {
        "id": "V2", "role": "Follow-up variant",
        "setup": "As P, plus --endpointExclude /JWT/votings/login,/JWT/refresh/checkout",
        "expected": set(), "basis": WEBGOAT_BASIS,
        "predicted": set(),
    },
]


def short(op):
    return op.replace("/WebGoat", "")


def fmt_set(ops):
    return "; ".join(sorted(short(o) for o in ops)) or "none"


def read_stats(run_dir):
    path = os.path.join(run_dir, "statistics.csv")
    if not os.path.isfile(path):
        return None
    with open(path, newline="") as f:
        return next(csv.DictReader(f), None)


def not_recognized_ops(run_dir):
    """Endpoints reported as Not-Recognized in one run (from report.json)."""
    descriptions, _ = read_fault_comments(run_dir)
    with open(os.path.join(run_dir, "report.json")) as f:
        report = json.load(f)
    ops = set()
    for fault in report["faults"]["foundFaults"]:
        for cat in fault["faultCategories"]:
            metric, _ = classify(str(cat["code"]), descriptions)
            if metric == "Not-Recognized":
                ops.add(fault["operationId"])
    return ops


TEST_HEADER_RE = re.compile(r"/\*\*\s*\n\s*\* Calls:\n(.*?)\*/\s*@Test[^\n]*\n\s*fun (\w+)", re.S)


def not_recognized_sequences(run_dir):
    """Call sequences (from the generated tests' 'Calls:' headers) of every test
    that shows a Not-Recognized fault. This shows which calls supplied the
    oracle's evidence."""
    descriptions, _ = read_fault_comments(run_dir)
    nr_codes = {c for c in descriptions if classify(c, descriptions)[0] == "Not-Recognized"}
    sequences = []
    for f in sorted(glob.glob(os.path.join(run_dir, "EvoMaster_*_Test.kt"))):
        with open(f, errors="ignore") as fh:
            content = fh.read()
        for m in TEST_HEADER_RE.finditer(content):
            header = m.group(1)
            codes = set(re.findall(r"\b(\d{3})\b", " ".join(
                line for line in header.splitlines() if "type-code" in line.lower())))
            if codes & nr_codes:
                calls = [line.strip(" *") for line in header.splitlines()
                         if re.match(r"\s*\*\s*(\d+ - )?\(\d{3}\)", line)]
                sequences.append((os.path.basename(f), m.group(2), calls))
    return sequences


def interpret(observed, expected):
    false_alarms = observed - expected
    missed = expected - observed
    if not false_alarms and not missed:
        return "correct"
    parts = []
    if false_alarms:
        parts.append(f"{len(false_alarms)} false alarm(s)")
    if missed:
        parts.append(f"missed {fmt_set(missed)}")
    return ", ".join(parts)


def prediction_check(observed, predicted):
    if observed == predicted:
        return "held"
    extra, lacking = observed - predicted, predicted - observed
    parts = []
    if extra:
        parts.append(f"also reported {fmt_set(extra)}")
    if lacking:
        parts.append(f"not reported {fmt_set(lacking)}")
    return "differs: " + ", ".join(parts)


def is_vote(verb, path):
    """POST /WebGoat/JWT/votings/<anything> is a vote, including the title "login";
    only GET /WebGoat/JWT/votings/login is the lesson's login."""
    return verb.upper() == "POST" and path.startswith("/WebGoat/JWT/votings/")


CALL_RE = re.compile(
    r'\.(get|post|put|delete|patch)\("\$\{baseUrlOfSut\}(/WebGoat/JWT/[^"?]*)[^"]*"\)'
    r'\s*\.then\(\)\s*\.statusCode\((\d+)\)')


def jwt_call_counts(run_dir):
    """{endpoint: Counter(status)} for the JWT calls kept in one run's generated tests."""
    counts = defaultdict(Counter)
    for f in glob.glob(os.path.join(run_dir, "EvoMaster_*_Test.kt")):
        with open(f, errors="ignore") as fh:
            for verb, path, code in CALL_RE.findall(fh.read()):
                if is_vote(verb, path):
                    path = "/WebGoat/JWT/votings/{title}"
                counts[f"{verb.upper()} {path}"][code] += 1
    return counts


def call_statuses(run_dir):
    """Print the status codes of the JWT calls kept in one run's generated tests."""
    counts = jwt_call_counts(run_dir)
    for endpoint in sorted(counts):
        print(f"  {endpoint:45} {dict(sorted(counts[endpoint].items()))}")


def parse_utc(text):
    from datetime import datetime, timezone
    text = text.rstrip("Z").split(".")[0]
    return datetime.strptime(text, "%Y-%m-%dT%H:%M:%S").replace(tzinfo=timezone.utc)


def read_kv(path):
    values = {}
    if os.path.isfile(path):
        for line in open(path):
            key, _, value = line.partition(":")
            values[key.strip()] = value.strip()
    return values


def run_index_row(case_id, run_dir):
    """Run metadata. run_meta.txt (written by the runners since A2) is used when
    present; for earlier runs the times and exit status are inferred from what
    EvoMaster recorded, and marked as such."""
    from datetime import timedelta
    stats = read_stats(run_dir) or {}
    env = read_kv(os.path.join(os.path.dirname(run_dir), "environment.txt"))
    meta = read_kv(os.path.join(run_dir, "run_meta.txt"))
    log = open(os.path.join(run_dir, "evomaster_stdout.log"), errors="ignore").read() \
        if os.path.isfile(os.path.join(run_dir, "evomaster_stdout.log")) else ""
    completed = "EvoMaster process has completed successfully" in log
    report_path = os.path.join(run_dir, "report.json")
    if meta:
        start, end, exit_status, source = meta.get("start_utc", ""), meta.get("end_utc", ""), meta.get("exit_status", ""), "run_meta.txt"
    elif os.path.isfile(report_path) and stats.get("elapsedSeconds"):
        end_dt = parse_utc(json.load(open(report_path))["creationTime"])
        start_dt = end_dt - timedelta(seconds=int(float(stats["elapsedSeconds"])))
        start, end = start_dt.strftime("%Y-%m-%dT%H:%M:%SZ"), end_dt.strftime("%Y-%m-%dT%H:%M:%SZ")
        exit_status = "0 (inferred: completed successfully)" if completed else "unknown (did not complete)"
        source = "inferred: report.json creationTime - statistics.csv elapsedSeconds"
    else:
        start = end = ""
        exit_status = "unknown (no report.json)"
        source = "none"
    return {
        "case": case_id, "run_id": f"{case_id}/{os.path.basename(run_dir)}",
        "seed": stats.get("seed", ""), "budget": stats.get("maxTime", ""),
        "auth_config": env.get("auth_config", ""), "extra_args": env.get("extra_args", ""),
        "start_utc": start, "end_utc": end, "elapsed_s": stats.get("elapsedSeconds", ""),
        "exit_status": exit_status, "evomaster_completed": "yes" if completed else "no",
        "time_source": source, "raw_output": os.path.relpath(run_dir, REPO_ROOT),
    }


CALL_DETAIL_RE = re.compile(
    # (?!given\(\)) keeps one match from running over into the next request,
    # e.g. from a login call (which has no statusCode) into the call after it.
    r'given\(\)(?P<pre>(?:(?!given\(\)).)*?)\.(?P<verb>get|post|put|delete|patch)\(\s*"\$\{baseUrlOfSut\}(?P<path>[^"?]*)(?P<query>[^"]*)"\)'
    r'\s*\.then\(\)\s*\.statusCode\((?P<code>\d+)\)', re.S)
TEST_BODY_RE = re.compile(r"\* Calls:\n(.*?)\*/\s*@Test[^\n]*\n\s*fun (\w+)\(\)(.*?)(?=\n    /\*\*|\Z)", re.S)


def normalize(request):
    """'GET /api/resources/550?x=1' -> 'GET /api/resources/{id}'; vote titles -> {title}."""
    verb, _, path = request.partition(" ")
    path = path.split("?")[0]
    if is_vote(verb, path):
        path = "/WebGoat/JWT/votings/{title}"
    return f"{verb} " + re.sub(r"/\d+(?=/|$)", "/{id}", path)


def evidence_rows(case_id, run_dir):
    """One row per generated test that shows a Not-Recognized fault. The last
    call is the reported one; the earlier calls are the oracle's evidence."""
    descriptions, _ = read_fault_comments(run_dir)
    nr_codes = {c for c in descriptions if classify(c, descriptions)[0] == "Not-Recognized"}
    rows = []
    for f in sorted(glob.glob(os.path.join(run_dir, "EvoMaster_*_Test.kt"))):
        content = open(f, errors="ignore").read()
        for m in TEST_BODY_RE.finditer(content):
            header_codes = set(re.findall(r"\b(\d{3})\b", " ".join(
                line for line in m.group(1).splitlines() if "type-code" in line.lower())))
            if not header_codes & nr_codes:
                continue
            calls = []
            for c in CALL_DETAIL_RE.finditer(m.group(3)):
                user = re.search(r"cookies\((cookies_\w+)\)", c.group("pre"))
                header_user = re.search(r'\.header\("Authorization", "(FOO|BAR)"\)', c.group("pre"))
                who = user.group(1).replace("cookies_", "") if user else (header_user.group(1) if header_user else "no auth")
                has_auth_header = ".header(\"Authorization\"" in c.group("pre") and not header_user
                calls.append({"user": who, "auth_header": has_auth_header,
                              "request": f"{c.group('verb').upper()} {c.group('path')}{c.group('query')}",
                              "code": c.group("code")})
            if len(calls) < 2:
                continue
            evidence = calls[:-1]
            if len({c["auth_header"] for c in evidence}) > 1:
                inputs_differ = "Authorization header"
            elif len({c["request"] for c in evidence}) > 1:
                inputs_differ = "query/path input"
            else:
                inputs_differ = "none"
            rows.append({
                "case": case_id, "run_id": f"{case_id}/{os.path.basename(run_dir)}",
                "test": f"{os.path.basename(f)}#{m.group(2)}",
                "reported_call": f"({calls[-1]['code']}) {calls[-1]['request']} as {calls[-1]['user']}",
                "evidence_calls": " -> ".join(
                    f"({c['code']}) {c['request']} as {c['user']}" + (" +Authorization" if c["auth_header"] else "")
                    for c in evidence),
                "evidence_endpoint": "; ".join(sorted({normalize(c["request"]) for c in evidence})),
                "evidence_inputs_differ_by": inputs_differ,
                "evidence_users_differ": "yes" if len({c["user"] for c in evidence}) > 1 else "no",
                "single_user_throughout": "yes" if len({c["user"] for c in calls}) == 1 else "no",
            })
    return rows


def call_status_rows(case_id, run_dirs):
    """Status codes per JWT endpoint and caller, summed over a case's runs."""
    totals = defaultdict(Counter)
    for run_dir in run_dirs:
        for f in glob.glob(os.path.join(run_dir, "EvoMaster_*_Test.kt")):
            for c in CALL_DETAIL_RE.finditer(open(f, errors="ignore").read()):
                path = c.group("path")
                if not path.startswith("/WebGoat/JWT/"):
                    continue
                if is_vote(c.group("verb"), path):
                    path = "/WebGoat/JWT/votings/{title}"
                caller = "logged-in user" if "cookies(" in c.group("pre") else "no session"
                totals[(f"{c.group('verb').upper()} {path}", caller)][c.group("code")] += 1
    return [{"case": case_id, "endpoint": ep, "caller": caller,
             "statuses": "; ".join(f"{code}: {n}" for code, n in sorted(counts.items()))}
            for (ep, caller), counts in sorted(totals.items())]


def write_csv(path, rows):
    if not rows:
        return
    with open(path, "w", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=list(rows[0].keys()))
        writer.writeheader()
        writer.writerows(rows)


def main():
    args = sys.argv[1:]
    if args and args[0] == "--calls":
        for d in args[1:]:
            print(d)
            call_statuses(d)
        return
    if args and args[0] == "--vote-accepted":
        accepted = any(jwt_call_counts(d)["POST /WebGoat/JWT/votings/{title}"]["202"] > 0 for d in args[1:])
        sys.exit(0 if accepted else 1)

    results_root = args[0] if args else os.path.join(REPO_ROOT, "raw", "a2")
    rows = []
    summaries = []
    index_rows, ev_rows, status_rows = [], [], []

    for case in CASES:
        case_dir = os.path.join(results_root, case["id"])
        run_dirs = sorted(glob.glob(os.path.join(case_dir, "run_*")), key=run_number)
        run_dirs = [d for d in run_dirs if read_stats(d) is not None]
        if not run_dirs:
            continue

        index_rows += [run_index_row(case["id"], d) for d in run_dirs]
        for d in run_dirs:
            ev_rows += evidence_rows(case["id"], d)
        if case["id"] != "K":
            status_rows += call_status_rows(case["id"], run_dirs)

        per_endpoint = Counter()
        budgets = set()
        interpretations, predictions = [], []
        for run_dir in run_dirs:
            stats = read_stats(run_dir)
            observed = not_recognized_ops(run_dir)
            per_endpoint.update(observed)
            budgets.add(stats.get("maxTime", ""))
            interpretation = interpret(observed, case["expected"])
            pred = prediction_check(observed, case["predicted"])
            interpretations.append(interpretation)
            predictions.append(pred)
            rows.append({
                "case": case["id"],
                "role": case["role"],
                "setup": case["setup"],
                "run": os.path.basename(run_dir),
                "seed": stats.get("seed", ""),
                "budget": stats.get("maxTime", ""),
                "endpoints_with_2xx": stats.get("covered2xx", ""),
                "expected_not_recognized": fmt_set(case["expected"]),
                "expected_basis": case["basis"],
                "observed_not_recognized": fmt_set(observed),
                "interpretation": interpretation,
                "prediction": pred,
                "raw_output": os.path.relpath(run_dir, REPO_ROOT),
            })

        n = len(run_dirs)
        reported = "; ".join(f"{short(op)} ({c}/{n})" for op, c in sorted(per_endpoint.items())) or "none"
        summaries.append({
            "case": case["id"], "role": case["role"], "runs": n,
            "budget": "/".join(sorted(budgets)),
            "expected": fmt_set(case["expected"]),
            "reported": reported,
            "interpretation": "; ".join(sorted(set(interpretations))),
            "prediction": "; ".join(sorted(set(predictions))),
        })

    if not rows:
        print(f"No A2 runs found under {results_root}")
        sys.exit(1)

    out_dir = os.path.join(REPO_ROOT, "derived")
    if os.path.abspath(results_root) != os.path.join(REPO_ROOT, "raw", "a2"):
        # Pilot or ad-hoc folders don't overwrite the reported results.
        out_dir = results_root
    out_csv = os.path.join(out_dir, "a2_results.csv")
    out_md = os.path.join(out_dir, "a2_summary.md")
    write_csv(out_csv, rows)
    write_csv(os.path.join(out_dir, "a2_run_index.csv"), index_rows)
    write_csv(os.path.join(out_dir, "a2_evidence.csv"), ev_rows)
    write_csv(os.path.join(out_dir, "a2_call_statuses.csv"), status_rows)

    lines = ["# Assignment 2 results", "",
             f"Generated by `python3 scripts/a2_table.py` from `{os.path.relpath(results_root, REPO_ROOT)}/`.",
             "", "## Not-Recognized reports per case", "",
             "| Case | Role | Runs | Budget | Expected | Reported (runs) | Interpretation | Prediction |",
             "|---|---|---|---|---|---|---|---|"]
    for s in summaries:
        lines.append(f"| {s['case']} | {s['role']} | {s['runs']} | {s['budget']} | {s['expected']} "
                     f"| {s['reported']} | {s['interpretation']} | {s['prediction']} |")

    replay_csv = os.path.join(results_root, "replays", "replays.csv")
    if os.path.isfile(replay_csv):
        lines += ["", "## Deterministic replays", "",
                  "| ID | Request | Expected | Observed | Match |", "|---|---|---|---|---|"]
        with open(replay_csv, newline="") as f:
            for r in csv.DictReader(f):
                lines.append(f"| {r['id']} | {r['request']} | {r['expected']} | {r['observed']} | {r['match']} |")

    lines += ["", "## Call sequences behind the Not-Recognized reports (first run of each case)", "",
              "Each test below was generated by EvoMaster's security phase; the calls are in order, "
              "with the status code each one got.", ""]
    for case in CASES:
        first = os.path.join(results_root, case["id"], "run_1")
        if read_stats(first) is None:
            continue
        lines.append(f"### {case['id']} ({os.path.relpath(first, REPO_ROOT)})")
        lines.append("")
        sequences = not_recognized_sequences(first)
        if not sequences:
            lines += ["No Not-Recognized test.", ""]
            continue
        for file_name, test_name, calls in sequences:
            lines.append(f"- `{file_name}` `{test_name}`: " + " → ".join(f"`{c}`" for c in calls))
        lines.append("")

    lines += ["", "## Run index", "",
              "| Run | Seed | Budget | Start (UTC) | End (UTC) | Exit status | Raw output |", "|---|---|---|---|---|---|---|"]
    for r in index_rows:
        lines.append(f"| {r['run_id']} | {r['seed']} | {r['budget']} | {r['start_utc']} | {r['end_utc']} "
                     f"| {r['exit_status']} | `{r['raw_output']}` |")
    sources = sorted({r["time_source"] for r in index_rows})
    lines += ["", f"Time source: {'; '.join(sources)}.", ""]

    lines += ["## Evidence analysis (all runs)", "",
              "Every generated test that shows a Not-Recognized fault, split into the reported call (last) "
              "and the oracle's evidence (the calls before it). Rows: `"
              + os.path.relpath(os.path.join(out_dir, "a2_evidence.csv"), REPO_ROOT) + "`.", "",
              "| Case | Tests | Evidence endpoint (tests) | Inputs differ between evidence calls (tests) | Users differ between evidence calls | Single user throughout |",
              "|---|---|---|---|---|---|"]
    for case in CASES:
        case_rows = [r for r in ev_rows if r["case"] == case["id"]]
        if not any(r["case"] == case["id"] for r in index_rows):
            continue
        endpoints = Counter(r["evidence_endpoint"] for r in case_rows)
        differs = Counter(r["evidence_inputs_differ_by"] for r in case_rows)
        users = sum(r["evidence_users_differ"] == "yes" for r in case_rows)
        single = sum(r["single_user_throughout"] == "yes" for r in case_rows)
        lines.append(f"| {case['id']} | {len(case_rows)} | "
                     + ("; ".join(f"{e} ({n})" for e, n in sorted(endpoints.items())) or "none") + " | "
                     + ("; ".join(f"{d} ({n})" for d, n in sorted(differs.items())) or "-")
                     + f" | {users} | {single} |")

    lines += ["", f"Per-run rows: `{os.path.relpath(out_csv, REPO_ROOT)}`. "
              f"Status codes per endpoint: `{os.path.relpath(os.path.join(out_dir, 'a2_call_statuses.csv'), REPO_ROOT)}`.", ""]
    with open(out_md, "w") as f:
        f.write("\n".join(lines))
    print("\n".join(lines))


if __name__ == "__main__":
    main()
