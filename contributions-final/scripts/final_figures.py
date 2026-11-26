#!/usr/bin/env python3
"""
final_figures.py -- figures of the final report, from derived/final_scaling.csv.

    python3 scripts/final_figures.py

Writes derived/fig_scaling_step_ms.svg (time of the Not-Recognized step) and
derived/fig_scaling_calls.svg (HTTP calls of the step), both against the
number of protected endpoints E, one line per number of users U, for proto
(solid) and forkoff (dashed). Medians over 3 runs. Standard library only
(plain SVG, readable by browsers and Markdown/PDF converters). The E axis
is ordinal (each step doubles E).
"""

import csv
import os

REPO_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
DERIVED = os.path.join(REPO_ROOT, "derived")
COLORS = {2: "#2a9d8f", 4: "#e8a33d", 8: "#c8553d"}
W, H = 640, 400
ML, MR, MT, MB = 70, 150, 40, 55


def load():
    rows = list(csv.DictReader(open(os.path.join(DERIVED, "final_scaling.csv"))))
    out = {}
    for r in rows:
        key = (r["variant"], int(r["U"]))
        val_ms = float(r["nr_step_ms_median"]) if r["nr_step_ms_median"] else None
        val_calls = float(r["nr_eval_calls_median"]) if r["nr_eval_calls_median"] else None
        out.setdefault(key, []).append((int(r["E"]), val_ms, val_calls, r["recall"]))
    for v in out.values():
        v.sort()
    return out


def nice_step(raw):
    """Smallest of 1, 2, 2.5 or 5 x 10^k that is at least raw."""
    k = 1
    while k * 10 <= raw:
        k *= 10
    for m in (1, 2, 2.5, 5, 10):
        if m * k >= raw:
            return m * k
    return 10 * k


def chart(series, metric_index, title, ylabel, path):
    es = sorted({e for pts in series.values() for e, *_ in pts})
    top = max(p[metric_index] for pts in series.values() for p in pts if p[metric_index] is not None)
    step = nice_step(top / 5)
    ymax = step * (int(top / step) + 1)
    pw, ph = W - ML - MR, H - MT - MB

    def x(e):
        return ML + es.index(e) / (len(es) - 1) * pw

    def y(v):
        return MT + ph - v / ymax * ph

    s = [f'<svg xmlns="http://www.w3.org/2000/svg" width="{W}" height="{H}" viewBox="0 0 {W} {H}" '
         f'font-family="Arial, Helvetica, sans-serif" font-size="12">',
         f'<rect width="{W}" height="{H}" fill="white"/>',
         f'<text x="{ML}" y="22" font-size="14" font-weight="bold">{title}</text>']
    # grid and y labels
    for k in range(int(round(ymax / step)) + 1):
        v = step * k
        yy = y(v)
        s.append(f'<line x1="{ML}" y1="{yy:.1f}" x2="{ML + pw}" y2="{yy:.1f}" stroke="#d9dee3"/>')
        s.append(f'<text x="{ML - 8}" y="{yy + 4:.1f}" text-anchor="end">{v:,.0f}</text>')
    for e in es:
        s.append(f'<text x="{x(e):.1f}" y="{MT + ph + 18}" text-anchor="middle">{e}</text>')
    s.append(f'<text x="{ML + pw / 2}" y="{H - 12}" text-anchor="middle">protected endpoints E</text>')
    s.append(f'<text transform="translate(16,{MT + ph / 2}) rotate(-90)" text-anchor="middle">{ylabel}</text>')
    s.append(f'<line x1="{ML}" y1="{MT + ph}" x2="{ML + pw}" y2="{MT + ph}" stroke="#3e4c59"/>')
    s.append(f'<line x1="{ML}" y1="{MT}" x2="{ML}" y2="{MT + ph}" stroke="#3e4c59"/>')
    legend_y = MT + 10
    for variant, dash in (("proto", ""), ("forkoff", ' stroke-dasharray="5,4"')):
        for u in (2, 4, 8):
            pts = [(pt[0], pt[metric_index]) for pt in series.get((variant, u), []) if pt[metric_index] is not None]
            if not pts:
                continue
            d = " ".join(f"{x(e):.1f},{y(v):.1f}" for e, v in pts)
            s.append(f'<polyline points="{d}" fill="none" stroke="{COLORS[u]}" stroke-width="2"{dash}/>')
            for e, v in pts:
                s.append(f'<circle cx="{x(e):.1f}" cy="{y(v):.1f}" r="3" fill="{COLORS[u]}"/>')
            lx = ML + pw + 14
            s.append(f'<line x1="{lx}" y1="{legend_y}" x2="{lx + 24}" y2="{legend_y}" stroke="{COLORS[u]}" stroke-width="2"{dash}/>')
            s.append(f'<text x="{lx + 30}" y="{legend_y + 4}">{variant}, U={u}</text>')
            legend_y += 18
    # mark the cell where the step hit the security phase time box
    for e, ms, calls, recall in series.get(("proto", 8), []):
        if recall not in ("1.00", "n/a") and (ms if metric_index == 1 else calls) is not None:
            v = ms if metric_index == 1 else calls
            s.append(f'<text x="{x(e) - 6:.1f}" y="{y(v) - 10:.1f}" text-anchor="end" fill="#c8553d">'
                     f'time box hit, recall {recall}</text>')
    s.append("</svg>")
    with open(path, "w") as f:
        f.write("\n".join(s) + "\n")
    print(path)


def main():
    series = load()
    chart(series, 1, "Time of the Not-Recognized step (median of 3 runs)", "milliseconds",
          os.path.join(DERIVED, "fig_scaling_step_ms.svg"))
    chart(series, 2, "HTTP calls of the Not-Recognized step (median of 3 runs)", "HTTP calls",
          os.path.join(DERIVED, "fig_scaling_calls.svg"))


if __name__ == "__main__":
    main()
