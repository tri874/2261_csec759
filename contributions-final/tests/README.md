# Tests and mechanism checks

The pilot cases themselves (primary, control, variant, regression) are in
`../cases/README.md`. This folder maps the checks that test the mechanism and
the expected results, with their IDs, expected outcomes and evidence. They live
next to the code they exercise, so this file only points to them.

| ID | Check | What it establishes | Where | Command | Expected | Observed |
|---|---|---|---|---|---|---|
| T1 | EvoMaster e2e `SecurityNotRecognizedConfirmationEMTest` (new) | with both rules on, the true fault in EvoMaster's own white-box `NotRecognizedApplication` is still reported as 305 | in `../patches/evomaster-v6.2.0-a3.patch` | `STEPS=tests ../scripts/a3_build_fork.sh` | pass | pass on v1, v2 and final (`../raw/a3/build/e2e_tests.log`, `../raw/a3_v2/build/`, `../raw/final/build/`) |
| T2 | EvoMaster e2e `SecurityNotRecognizedEMTest` (upstream, unchanged) | default behavior (rules off) unchanged | upstream | same | pass | pass on v1, v2 and final |
| T3 | `ConfigToMarkdownTest`, `ExperimentalFaultCategoryTest` (upstream) | options documented; code 950 unique among fault codes | upstream | same | pass | pass on v1, v2 and final (`unit_tests.log`) |
| T4 | Ablation `rule1` (Rule 2 off) and `rule2` (Rule 1 off) | which rule explains the effect on H1, H4, P | `../scripts/a3_run_all.sh` items `rule1:*`, `rule2:*` | see `../README.md` | H1: rule1 keeps the false alarm, rule2 removes it; H4: the reverse; P: both remove all | as expected, v1 and v2 (`../derived/a3_summary*.md`) |
| T5 | Build check `forkoff` (our image, rules off) | our build behaves like the official image | items `forkoff:K`, `forkoff:P` | same | same reports as baseline | identical (P: 5 endpoints 3/3; K: 3/3) |
| T6 | Curl ground truth of H1, H1c, H2, H4 | expected results independent of EvoMaster | `../scripts/a3_replays.sh` | `../scripts/a3_replays.sh` | 18/18 | 18/18 (`../raw/a3/replays/`) |
| T7 | A2 replays R1–R7 on WebGoat and K | target state unchanged since A2 | `../scripts/a2_replays.sh` | (part of `a3_run_all.sh`) | 12/12 | 12/12 (`../raw/a3/replays_a2/`) |
| T8 | Diagnostics rerun (D3) | why H2's 950 was lost in v1 | `../patches/evomaster-a3-diagnostics.patch` | see `../README.md` | one `A3-DIAG` line per constructed test | cause identified (`../notes/a3_decisions.md`, `../raw/a3_diag/`) |
| T9 | Curl ground truth of H5–H8 (final) | expected results of the held-out cases, independent of EvoMaster | `../scripts/final_replays.sh` | `../scripts/final_replays.sh` (or `APP_MODE=local` with Flask, no Docker) | 21/21 | 21/21 (`../raw/final/replays/`, also in `../raw/final_smoke2/replays/`) |
| T10 | Ablation on the held-out cases and crAPI (final) | the T4 mechanism on cases not used to develop the rules | items `rule1:*`, `rule2:*` of `../scripts/final_run_all.sh` | `GROUP=synthetic`, `GROUP=crapi` | H5 and crAPI: rule1 keeps the false alarm, rule2 removes it; H6: rule1 loses the fault, rule2 keeps it | as expected (`../derived/final_summary.md`) |
| T11 | Build check `forkoff` on the full WebGoat API and crAPI (final) | T5 on full-size real targets | items `forkoff:wgfull`, `forkoff:crapi` | `GROUP=webgoat`, `GROUP=crapi` | same reports as baseline | identical (WebGoat: 5 JWT endpoints 3/3; crAPI: login 3/3) |
| T12 | Regression: A3 cases on the final image | the final patch (logging only) changes no verdict | `../scripts/a3_run_all.sh` with `PROTO_IMAGE=evomaster-final:…` | see `../README.md` | A3 v2 verdicts | identical (`../derived/a3_summary_final_regress.md`) |
| T13 | Cost log line present with rules on and off | the cost measure exists for proto and forkoff | `../patches/evomaster-final-cost-log.patch` | any final run | one `Not-Recognized step cost (final)` line per run of our image | present in every run of our image (`../derived/final_runs.csv`, `nr_step_ms`) |
