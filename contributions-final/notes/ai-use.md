# AI use

## Assignment 1

Claude Sonnet 5 was used for troubleshooting docker bugs and docker networking bugs. It was also used for determining what dependencies were needed for errors that were occuring, such as dependencies that wern't listed by the original authors.

A suggestion that was rejected was the auotmated execution of every API that was referenced in the paper. The white-box APIs in the paper are real-world systems, including familie-ba-sak, the Norwegian public administration's child benefit case processing system. They are outside the WebGoat target of this reproduction, so Claude's suggestion to test them as well was rejected.

A suggestion that was accepted was auomated aggregation of results. All of the differnet experiments across all of teh different sites produced many different files in various palces, and Claud was able to provide a script (scripts/extract_metrics.py) that puts all of the metrics into 1 clean summary table and CSV.

Claude Opus was used to review the finished experiment against the paper, to find and fix configuration problems in the run script (a doubled /WebGoat target URL and a search budget that didn't match the paper), and to help draft the presentation materials.

## Assignment 2

Claude Opus 5.5 read and wrote files in the repository, read the WebGoat and EvoMaster source on GitHub, and read (but did not type into) the SSH terminal on the shared VMs. All experiment runs were started by us on the VMs.

**Interaction summary**

1. Claude analysed the A1 baseline output, traced the 5 Not-Recognized reports to the WebGoat JWT lesson source and to EvoMaster's oracle code, and proposed the failure family, cases and an A3 change. We chose to keep the report centred on WebGoat and to keep case K.
2. Claude then implemented the code
3. As errors surfaced during testing, Claude made fixes to the code as instructed by Tri and James


**Incorporated output.** `cases/`, `environment/config/webgoat-em-c-*.yaml`, `environment/versions.md`, `scripts/a2_*.{sh,py}`, `scripts/run_evomaster_case.sh`, changes to `scripts/run_evomaster_webgoat.sh`, `notes/a2_predictions.md`, and `notes/a2_investigation_log.md`

**How we verified it.**

- Every number in the write-up is produced by `python3 scripts/a2_table.py`, which regenerates `derived/` exactly from `raw/`.
- The expected behaviour was checked outside EvoMaster: the WebGoat source lines were read directly, and the deterministic replays (`raw/a2/replays/`) matched 12/12.
- Case K was checked against the behaviour the original EvoMaster test app is designed to show (K reported 3/3; replays R7a–c).

**Suggestions that were corrected or rejected.**

- Claude's first K schema declared `{id}` at path level, which EvoMaster 6.2.0 cannot read (EvoMaster's warning in the pilot).
- The planned cookie-based control did not work with EvoMaster's fixed  headers (pilot); the pre-registered Authorization-header control was used instead.
- Claude's prediction for V (three reports disappear) was wrong; the lternative it recorded with it held, which led to V2.
- The plan's first A3 rule counted login redirects as evidence; the V2 result showed this would bring the false alarms back, so it was revised.

## Assignment 3

Claude Opus 5.5 (Claude Code desktop app) worked in the repository in joint sessions with both of (Tri and James). It read the EvoMaster v6.2.0 and WFC v0.8.0 source, wrote code and documents, and committed and pushed to our GitHub repository when we asked it to. It had no access to the VM: we pulled the commits, ran every build and experiment manually, evaluated the reusults, and provided Claude with what needed to be done next.

**Interaction summary**

1. From the A2 plan, Claude studied `RestSecurityOracle` / `RestSecurityBuilder` and wrote the patch. We asked for both rules behind separate switches, so that each can be ablated.
2. Claude designed the synthetic cases with their expected results, the run, replay and table scripts, and the predictions. We reviewed them and committed the predictions before any run.
3. After the pilot, Claude proposed the logging-only diagnostics for the H2 miss instead of a guessed fix; the diagnostics identified two bugs in its own builder code, fixed in v2 (D3).
4. Claude drafted notes for the report that were re-worded individuall into our own respective `report.pdf`'s.

**Incorporated output.** `patches/*.patch`, `scripts/a3_*`, the A3 changes to `scripts/run_evomaster_*.sh`, `cases/a3_synthetic_app/`, `cases/H*/`, `cases/README.md`, `notes/a3_predictions.md`, `notes/a3_decisions.md`, `environment/` A3 sections, `README.md`, the `report.pdf` draft notes.

**How we verified it.**

- The patch compiled on the VM, and EvoMaster's tests touched by it passed including the new e2e test (`raw/a3/build/`).
- Expected results come from the cases' code and are checked with curl, independently of EvoMaster (`raw/a3/replays/` 18/18; A2 replays 12/12).
- Predictions were committed before the runs and compared with the results; the one miss (H2) was investigated with logged evidence, not explained away.
- `forkoff` (our build with the rules off) matches the official image on P and K.
- Every reported number is regenerated from `raw/` by `scripts/a3_table.py`.

**Suggestions corrected or rejected.**

- Claude's first builder code lost tests on H2 (D3): the replay copied the save-location flag, and the bookkeeping counted a rejected test as kept.
- Security-phase duration was planned as the cost measure; the data showed it too noisy at 1 s resolution (baseline 7–33 s on P), so replay calls are reported instead, and a millisecond timer is a remaining task.


## Final project

Same setup as A3: Claude Opus 5.5 (Claude Code desktop app) worked in the repository in joint sessions with both of us, read the EvoMaster, WFC and crAPI source and the baseline paper's extended version, wrote code and documents, and committed and pushed when we asked. It had no access to the VM: we pulled, ran every build and run there, and pushed the raw output back; Claude read the pushed output.

**Interaction summary**

1. Claude mapped the final-project rubric against the A3 plan; we chose the full plan with crAPI required, one VM, and the existing folder.
2. Claude wrote the crAPI setup, the cost-log patch, the held-out cases H5–H8 with their labels and predictions, the scaling generator, the campaign, table and figure scripts. We committed the predictions before any final run.
3. Three crAPI setup problems surfaced on the VM (missing `1.1.6` images, MongoDB thrashing at 128 MB, the web gateway exiting without the chatbot) and one validity problem in the smoke runs (EvoMaster changing the users' passwords). Claude diagnosed each from the output we pasted and proposed the fixes in D4; we approved removing the old crAPI containers on the VM.
4. After the runs, Claude found that the WebGoat baseline reused from A1 did not match the prototype's throughput and proposed fresh baseline and `forkoff` runs (D5); we ran them.
5. Claude labelled the crAPI report from crAPI's source and the runs' replays, and drafted `report.md` and the README.

**Incorporated output.** `patches/evomaster-final-cost-log.patch`, `scripts/final_*`, the `TESTS_OUT` option of `scripts/a3_build_fork.sh`, `cases/crapi/`, `cases/final_synthetic_app/`, `cases/H5_*`–`H8_*`, `cases/final_scaling_app/`, `cases/final_scaling/`, `notes/final_*`, the final sections of `cases/README.md` and `tests/README.md`, `README.md`, the `report.md` draft.

**How we verified it.**

- The final image built on the VM (`environment/final_build.txt`) and gave exactly the A3 v2 verdicts on all seven A3 cases (`raw/final_regress/`).
- H5–H8's expected results were checked with curl before the runs (21/21, `raw/final/replays/`), and the predictions committed before any run held in every cell.
- The crAPI label comes from crAPI's source (`AuthController.authenticateUser`) and the replays inside the runs, not from EvoMaster's verdict.
- `forkoff` matches the official image on WebGoat and crAPI; every number is regenerated from `raw/` by `scripts/final_table.py`.

**Suggestions corrected or rejected.**

- Claude's first crAPI setup used image tags that do not exist and crAPI's default container limits; both failed on the VM and were fixed (D4).
- Claude's first prediction for crAPI (Rule 1 would find no evidence, because crAPI answers some token-less requests with 404) was wrong: Rule 1 found genuine evidence on the orders endpoint.
- Claude's plan to reuse A1's WebGoat baseline (D5) was revised after the throughput mismatch.
- A configurable cap on evidence retries, planned in A3, was not implemented; the scaling results show where it would matter.
