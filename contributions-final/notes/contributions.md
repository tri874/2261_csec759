# Contributions

| Member | Student ID |
|---|---|
| James Southcott | jms9508 |
| Tri Tran | ttt6380 |

Each member must be able to explain the shared result (assignment brief,
"Submission and collaboration").

## James Southcott

- Directed the AI-assisted analysis, plan and code (see `notes/ai-use.md`);
- Ran the Assignment 2 experiments on the shared VMs: pilot, full run (K, P, C-alt, V, replays) and V2 (`raw/a2/orchestrator_logs/`, `raw/a2/`
- Wrote individual `report.pdf`

## Tri Tran

- Assisted in AI-assisted analysis, plan, and code, was sitting with James while development occured.
- Monitored and observed the Assignment 2 experiments on the shared VMs, identified bugs and errors in code and analyzed results. 
- Wrote individual `report.pdf`


# Assignment 3

James Southcott and Tri Tran split the A3 work 50/50 and did it together: both worked on all the code (in joint sessions with Claude, see `ai-use.md`), developed the prompts together, oversaw the test and pilot runs on the shared VM, and reviewed the results and this report. Each of us can explain every part.

| Work | Files / runs | Who |
|---|---|---|
| EvoMaster patch (Rules 1 and 2, category 950, options, e2e test) | `patches/evomaster-v6.2.0-a3.patch` | both |
| Build and run scripts | `scripts/a3_build_fork.sh`, `scripts/a3_run_all.sh`, `scripts/a3_replays.sh`, `scripts/a3_table.py`; `KEEP_GOING` and local-image support in `scripts/run_evomaster_*.sh` | both |
| Cases and labels | `cases/a3_synthetic_app/`, `cases/H1_apikey/`, `cases/H1c_apikey_userbug/`, `cases/H2_role/`, `cases/H4_misconfigured_user/`, `cases/README.md` | both |
| Predictions (before the runs) | `notes/a3_predictions.md` (commit `b9b3fc2`; v2 addendum `69c1b7d`) | both |
| Build, EvoMaster tests, smoke run, pilot (66 runs), diagnostics rerun, v2 rerun on the VM | `raw/a3/orchestrator_logs/`, `raw/a3/build/`, `raw/a3_smoke/`, `raw/a3/`, `raw/a3_diag/`, `raw/a3_v2/` | both (runs started on the VM by us) |
| H2 investigation and fix (D3) | `notes/a3_decisions.md`, `patches/evomaster-a3-diagnostics.patch`, `patches/evomaster-a3-fix-replay-stopping.patch` | both |


# Final project

As in A3, James Southcott and Tri Tran did the final project together and equally: both worked on all of the code in joint sessions with Claude (`ai-use.md`), decided the scope and the fixes, ran and monitored the campaign on the shared VM, checked the results and reviewed the report. Each of us can explain every part.

| Work | Files / runs | Who |
|---|---|---|
| Cost-log patch and final image | `patches/evomaster-final-cost-log.patch`, `environment/final_build.txt` | both |
| crAPI setup and labels | `cases/crapi/`, `scripts/final_crapi.sh`, `notes/final_decisions.md` D4, `notes/final_labels.*` | both |
| Held-out cases H5–H8 and predictions | `cases/final_synthetic_app/`, `cases/H5_*`–`H8_*`, `scripts/final_replays.sh`, `notes/final_predictions.md` | both |
| Scaling generator | `cases/final_scaling_app/`, `scripts/final_gen_scaling.py`, `cases/final_scaling/` | both |
| Campaign, tables, figures | `scripts/final_run_all.sh`, `scripts/final_table.py`, `scripts/final_figures.py` | both |
| Runs on the VM (smoke, 150 final runs, WebGoat reruns, regression) | `raw/final*`, `raw/final_regress/` | both |
