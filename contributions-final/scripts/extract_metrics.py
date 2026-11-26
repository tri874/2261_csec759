#!/usr/bin/env python3
"""
extract_metrics.py

Reconstructs a Table-III-style summary (SUT, H500, Schema, Not-Recognized,
Leakage, Missed-Check) from EvoMaster's statistics.csv output, AND shows
the per-run breakdown + spread (min/max/stdev) behind each average -- so
you can tell "found ~4 every time" apart from "found 0 nine times and 40
once", which the paper's single-number Table III doesn't distinguish
either, but which matters for judging how stable/trustworthy a result is.

Primary source: the `potentialFaultsSummary` column, a list of "code:count"
pairs, e.g. "101:204" (EvoMaster 6.1.x, ";"-separated) or
"100:28|200:320|305:5" (EvoMaster 6.2.x, "|"-separated).

The fault codes changed between EvoMaster versions (e.g. Schema is 101 in
6.1.1 but 200 in 6.2.0), so each code is mapped to a Table III metric by the
description EvoMaster writes next to it in the generated tests
("// Fault200. Schema Violation: ..."). The patterns follow the wording of
the paper's Figures 1-3:
    H500           "HTTP Status 500"
    Schema         "...Not Matching Its Schema"
    Not-Recognized "Wrongly Not Recognized as Authenticated"
    Leakage        "Leakage Information Existence of Protected Resource"
    Missed-Check   "Forbidden Delete But Allowed Modifications"
Codes seen so far: 6.1.1 uses 100/101/800/801/802; 6.2.0 uses 100/200/305
for H500/Schema/Not-Recognized. Any other codes (e.g. EvoMaster's newer
HTTP-semantics and XSS oracles) are not part of Table III; they are listed
separately with their descriptions rather than silently dropped.

Cross-checks (printed as warnings, not silently trusted):
    - `distinct500Faults` column should match the H500 count exactly.
    - Each Not-Recognized/Leakage/Missed-Check fault should be shown by at
      least one commented test in the generated .kt files.
    - Codes with no description in the test files fall back to the 6.1.1
      numbering, with a warning.
    - `covered2xx` should be above 0. If no endpoint ever returned a 2xx,
      the target URL or the logins were wrong, and the access-control
      oracles had nothing to work with.
    - All runs of a SUT should use the same `maxTime` search budget.

Runs missing statistics.csv are reported separately as FAILED runs and
excluded from the average's denominator (rather than silently counted as
zero, which would understate a real result if some runs simply didn't
produce output due to a crash/config issue rather than genuinely finding
nothing).

Usage:
    python3 extract_metrics.py raw/
    python3 extract_metrics.py raw/ --brief            # summary table only
    python3 extract_metrics.py raw/ --csv summary.csv  # also write a CSV
"""

import sys
import re
import csv
import glob
import os
import statistics
from collections import defaultdict

METRIC_PATTERNS = [
    ("H500", re.compile(r"HTTP Status 500", re.I)),
    ("Schema", re.compile(r"Not Matching Its Schema", re.I)),
    ("Not-Recognized", re.compile(r"Not Recognized as Authenticated", re.I)),
    ("Leakage", re.compile(r"Existence of Protected Resource", re.I)),
    ("Missed-Check", re.compile(r"Forbidden \w+ But Allowed", re.I)),
]

# Only used for a code that has no description in the test files.
FALLBACK_CODE_TO_METRIC = {
    "100": "H500",
    "101": "Schema",
    "800": "Leakage",
    "801": "Not-Recognized",
    "802": "Missed-Check",
}

METRIC_ORDER = ["H500", "Schema", "Not-Recognized", "Leakage", "Missed-Check"]
ACCESS_METRICS = ("Not-Recognized", "Leakage", "Missed-Check")

# e.g. "// Fault305. Wrongly Not Recognized as Authenticated. POST:/..."
FAULT_COMMENT_RE = re.compile(r"Fault(\d{3})\. ([^.\n]+)")

# Wide enough for the longest metric name plus a gap, so headers never run together.
COL_W = max(len(m) for m in METRIC_ORDER) + 2


def parse_fault_summary(summary_str):
    """Return {code: count} from potentialFaultsSummary."""
    counts = defaultdict(int)
    if not summary_str:
        return counts
    # EvoMaster 6.1.x separates pairs with ";", 6.2.x with "|".
    for pair in re.split(r"[;|]", summary_str):
        pair = pair.strip()
        if not pair or ":" not in pair:
            continue
        code, count_str = pair.split(":", 1)
        try:
            counts[code.strip()] += int(count_str.strip())
        except ValueError:
            continue
    return counts


def classify(code, descriptions):
    """Return (metric or None, used_fallback) for one fault code."""
    desc = descriptions.get(code)
    if desc is None:
        metric = FALLBACK_CODE_TO_METRIC.get(code)
        return metric, metric is not None
    for metric, pattern in METRIC_PATTERNS:
        if pattern.search(desc):
            return metric, False
    return None, False


def to_int(value):
    try:
        return int(float(value or 0))
    except ValueError:
        return 0


def read_run_statistics(csv_path):
    """Read the single row EvoMaster writes to one run's statistics.csv."""
    with open(csv_path, newline="") as f:
        reader = csv.DictReader(f)
        row = next(reader, None)
    if row is None:
        return None
    return {
        "codes": parse_fault_summary(row.get("potentialFaultsSummary", "")),
        "distinct500": to_int(row.get("distinct500Faults")),
        "covered2xx": to_int(row.get("covered2xx")),
        "endpoints": to_int(row.get("endpoints")),
        "max_time": row.get("maxTime", ""),
        "seed": row.get("seed", ""),
        "id": row.get("id", ""),
    }


def read_fault_comments(run_dir):
    """Return ({code: description}, {code: comment count}) from the generated tests."""
    descriptions = {}
    counts = defaultdict(int)
    for f in glob.glob(os.path.join(run_dir, "EvoMaster_*_Test.kt")):
        with open(f, "r", errors="ignore") as fh:
            content = fh.read()
        for code, desc in FAULT_COMMENT_RE.findall(content):
            descriptions.setdefault(code, desc.strip())
            counts[code] += 1
    return descriptions, counts


def fmt_stats(values):
    """Return a compact 'mean (min-max, stdev)' string for a list of run counts."""
    if not values:
        return "n/a"
    mean = sum(values) / len(values)
    lo, hi = min(values), max(values)
    sd = statistics.stdev(values) if len(values) > 1 else 0.0
    return f"{mean:6.2f}  (min={lo}, max={hi}, sd={sd:.2f})"


def run_number(path):
    """Sort key so run_2 comes before run_10."""
    m = re.search(r"run_(\d+)$", os.path.normpath(path))
    return int(m.group(1)) if m else float("inf")


def find_sut_dirs(results_root):
    """
    Auto-detect whether results_root IS a single SUT's directory (contains
    run_* folders directly) or a parent containing multiple SUT folders
    (each of which contains run_* folders).

    Returns a list of (sut_name, sut_dir_path) tuples.
    """
    direct_runs = glob.glob(os.path.join(results_root, "run_*"))
    direct_runs = [d for d in direct_runs if os.path.isdir(d)]

    if direct_runs:
        # results_root itself is a single SUT's directory
        sut_name = os.path.basename(os.path.abspath(results_root))
        return [(sut_name, results_root)]

    # otherwise, treat results_root as a parent of multiple SUT directories
    candidates = sorted(
        d for d in glob.glob(os.path.join(results_root, "*")) if os.path.isdir(d)
    )
    return [(os.path.basename(d), d) for d in candidates]


def write_csv(path, per_run_rows, summary_rows):
    with open(path, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(["SUT", "run", "seed", "maxTime", "covered2xx"] + METRIC_ORDER)
        for row in per_run_rows:
            writer.writerow(row)
        for sut_name, avgs, n_ok, _n_fail, budgets in summary_rows:
            writer.writerow(
                [sut_name, f"mean (n={n_ok})", "", "/".join(budgets), ""]
                + [f"{a:.1f}" for a in avgs]
            )


def main():
    args = sys.argv[1:]
    brief = "--brief" in args
    args = [a for a in args if a != "--brief"]

    csv_out = None
    if "--csv" in args:
        idx = args.index("--csv")
        if idx + 1 >= len(args):
            print("--csv needs an output file path")
            sys.exit(1)
        csv_out = args[idx + 1]
        del args[idx:idx + 2]

    if len(args) != 1:
        print(f"Usage: {sys.argv[0]} <results_dir> [--brief] [--csv <file>]")
        print(f"  <results_dir> can be either:")
        print(f"    - a single SUT's folder (containing run_1, run_2, ... directly), or")
        print(f"    - a parent folder containing multiple SUT folders (e.g. capital/, crapi/, webgoat/)")
        sys.exit(1)

    results_root = args[0]
    sut_entries = find_sut_dirs(results_root)
    if not sut_entries:
        print(f"No SUT directories or run_* folders found under {results_root}")
        sys.exit(1)

    warnings = []
    summary_rows = []
    per_run_rows = []

    for folder_name, sut_dir in sut_entries:
        run_dirs = sorted(glob.glob(os.path.join(sut_dir, "run_*")), key=run_number)
        if not run_dirs:
            continue

        per_run_values = {m: [] for m in METRIC_ORDER}   # only successfully-read runs
        run_labels = []                                    # run_dir names, successful only
        failed_runs = []
        other_codes = defaultdict(list)
        code_labels = {}                                   # code -> metric or description
        budgets = []
        ids = set()

        for run_dir in run_dirs:
            run_name = os.path.basename(run_dir)
            csv_path = os.path.join(run_dir, "statistics.csv")
            stats = read_run_statistics(csv_path) if os.path.isfile(csv_path) else None
            if stats is None:
                failed_runs.append(run_name)
                continue

            descriptions, comment_counts = read_fault_comments(run_dir)
            fault_counts = defaultdict(int)

            for code, count in stats["codes"].items():
                metric, used_fallback = classify(code, descriptions)
                if metric is None:
                    other_codes[code].append(count)
                    code_labels.setdefault(code, descriptions.get(code, "no description"))
                    continue
                fault_counts[metric] += count
                code_labels.setdefault(code, metric)
                if used_fallback:
                    warnings.append(
                        f"{run_dir}: code {code} has no description in the test files; "
                        f"assumed {metric} from the EvoMaster 6.1.1 numbering"
                    )
                if metric in ACCESS_METRICS and comment_counts.get(code, 0) < count:
                    warnings.append(
                        f"{run_dir}: {metric} (code {code}) -- statistics.csv={count}, "
                        f"but only {comment_counts.get(code, 0)} commented test(s) show it"
                    )

            if fault_counts.get("H500", 0) != stats["distinct500"]:
                warnings.append(
                    f"{run_dir}: H500 mismatch -- potentialFaultsSummary="
                    f"{fault_counts.get('H500', 0)}, distinct500Faults={stats['distinct500']}"
                )
            if stats["covered2xx"] == 0:
                warnings.append(
                    f"{run_dir}: 0 of {stats['endpoints']} endpoints returned a 2xx -- "
                    f"target URL or logins were likely wrong, so these counts are not meaningful"
                )

            if stats["max_time"] and stats["max_time"] not in budgets:
                budgets.append(stats["max_time"])
            if stats["id"]:
                ids.add(stats["id"])

            run_labels.append(run_name)
            for m in METRIC_ORDER:
                per_run_values[m].append(fault_counts.get(m, 0))

        # Prefer EvoMaster's own statisticsColumnId, keeping the folder name
        # when it differs so result sets of the same SUT stay distinguishable.
        sut_id = ids.pop() if len(ids) == 1 else folder_name
        sut_name = sut_id if sut_id == folder_name else f"{sut_id} ({folder_name})"
        n_ok = len(run_labels)

        if len(budgets) > 1:
            warnings.append(f"{sut_name}: runs used different search budgets ({', '.join(budgets)})")

        # ---- SUT header ----
        print(f"\n=== {sut_name} ===  ({n_ok} successful run(s)"
              + (f", {len(failed_runs)} FAILED: {', '.join(failed_runs)}" if failed_runs else "")
              + ")")

        if n_ok == 0:
            print("  No successful runs -- nothing to report.")
            continue

        print(f"  search budget per run: {', '.join(budgets) or 'unknown'}")
        mapped = [f"{c}={code_labels[c]}" for c in sorted(code_labels) if code_labels[c] in METRIC_ORDER]
        print(f"  fault codes used for Table III: {', '.join(mapped) or 'none found'}")

        if not brief:
            # Per-run raw table
            header = f"{'run':<10}" + "".join(f"{m:>{COL_W}}" for m in METRIC_ORDER)
            print(header)
            for i, run_name in enumerate(run_labels):
                row = f"{run_name:<10}" + "".join(
                    f"{per_run_values[m][i]:>{COL_W}}" for m in METRIC_ORDER
                )
                print(row)
            print("-" * len(header))

        # Per-metric mean/min/max/stdev
        for m in METRIC_ORDER:
            print(f"  {m:<15}: {fmt_stats(per_run_values[m])}")

        if other_codes:
            print("  Other fault codes (not in Table III):")
            for code in sorted(other_codes):
                print(f"    code {code}: {fmt_stats(other_codes[code] + [0] * (n_ok - len(other_codes[code])))}"
                      f"  {code_labels[code]}")

        avgs = [sum(per_run_values[m]) / n_ok for m in METRIC_ORDER]
        summary_rows.append((sut_name, avgs, n_ok, len(failed_runs), budgets))

        for i, run_name in enumerate(run_labels):
            stats = read_run_statistics(os.path.join(sut_dir, run_name, "statistics.csv"))
            per_run_rows.append(
                [sut_name, run_name, stats["seed"], stats["max_time"], stats["covered2xx"]]
                + [per_run_values[m][i] for m in METRIC_ORDER]
            )

    # ---- Final Table-III-style summary across all SUTs ----
    print("\n\n=== Table III style summary (averages only) ===")
    sut_w = max([15] + [len(row[0]) + 2 for row in summary_rows])
    header = f"{'SUT':<{sut_w}}" + "".join(f"{m:>{COL_W}}" for m in METRIC_ORDER) + "   runs"
    print(header)
    print("-" * len(header))
    for sut_name, avgs, n_ok, n_fail, _budgets in summary_rows:
        note = f"n={n_ok}" + (f" (+{n_fail} failed)" if n_fail else "")
        print(f"{sut_name:<{sut_w}}" + "".join(f"{a:>{COL_W}.1f}" for a in avgs) + f"   {note}")

    if csv_out:
        write_csv(csv_out, per_run_rows, summary_rows)
        print(f"\nWrote {csv_out}")

    if warnings:
        print("\n--- Cross-check warnings (investigate before trusting results) ---")
        for w in warnings:
            print(f"  ! {w}")


if __name__ == "__main__":
    main()
