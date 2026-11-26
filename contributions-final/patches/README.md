# Source changes (patches against EvoMaster v6.2.0)

All code in these patches was written by us (with Claude, see
`../notes/ai-use.md`). Everything else in EvoMaster is upstream and unmodified.

## Upstream version and retrieval

| Item | Value |
|---|---|
| Repository | https://github.com/WebFuzzing/EvoMaster (LGPL-3.0) |
| Tag | `v6.2.0` |
| Commit | `efad6f2bd7ff0025852a6203d307303c568e763a` |
| Same version as the baseline image | `webfuzzing/evomaster@sha256:de1f4387e809a309a4c61517f3340c3d0b733b78bbb86d0e3ebd217d343515ab` |

Manual retrieval and application (what `../scripts/a3_build_fork.sh` automates,
including the commit check, the Maven build in Docker and the image build):

```bash
git clone --depth 1 --branch v6.2.0 https://github.com/WebFuzzing/EvoMaster.git evomaster-a3
cd evomaster-a3 && git rev-parse HEAD     # must print efad6f2bd7ff0025852a6203d307303c568e763a
git apply ../patches/evomaster-v6.2.0-a3.patch                 # v1
git apply ../patches/evomaster-a3-diagnostics.patch            # v2 = v1 + these two
git apply ../patches/evomaster-a3-fix-replay-stopping.patch
git apply ../patches/evomaster-final-cost-log.patch            # final = v2 + this
```

## The patches (apply in this order)

| Patch | SHA-256 | Version | Content |
|---|---|---|---|
| `evomaster-v6.2.0-a3.patch` | `b9a4cdd80388c9db556840a1cd167f481c3b554cde96d34bd4e7cccf4d98ee74` | v1, the pilot (`raw/a3/`) | Rules 1 and 2, category 950, options, replays, e2e test |
| `evomaster-a3-diagnostics.patch` | `fbe4a119831cffbfd7a7b32d06c12632e954a61915db993ced5dab9fe9c47e8b` | diagnostics (`raw/a3_diag/`) and v2 | one `A3-DIAG` log line per constructed test; no change to decisions |
| `evomaster-a3-fix-replay-stopping.patch` | `3eec7e4a35f1184e180801d5ca7dc840deaab78c7926fdbdf6926a8f9f5c1e87` | v2 (`raw/a3_v2/`) | fix of decision D3 (`../notes/a3_decisions.md`) |
| `evomaster-final-cost-log.patch` | `5b1bbe97bf054b7afbdaebc25eebe5d5b80ca02e908d1884bbad93b80bbdb35c` | final (`raw/final/`) | logging only: one `Not-Recognized step cost (final)` line (elapsed ms, evaluated tests and HTTP calls of the step), with the rules on or off (`../notes/final_decisions.md` D6); no change to decisions |

## Modified upstream files

| Upstream file | Patch | What we changed |
|---|---|---|
| `core/src/main/kotlin/org/evomaster/core/problem/rest/oracle/RestSecurityOracle.kt` | v1 | `handleNotRecognizedAuthenticated` chooses 305 or 950; new `isNotRecognizedConfirmed`, `hasCredentialDifferentialEvidence` (Rule 1), `isNotRecognizedAttributableToUser` (Rule 2), `statusOf`, `requestSignature` |
| `core/src/main/kotlin/org/evomaster/core/problem/rest/service/RestSecurityBuilder.kt` | v1, diagnostics, fix, final | `handleNotRecognizedAuthenticated`: Y ≠ X, replays, retry over evidence endpoints, summary log line; new `addNotRecognizedReplays`; `A3-DIAG` logging; D3 fix; final: cost log line |
| `core/src/main/kotlin/org/evomaster/core/problem/enterprise/ExperimentalFaultCategory.kt` | v1 | new `SECURITY_NOT_RECOGNIZED_UNCONFIRMED` (code 950) |
| `core/src/main/kotlin/org/evomaster/core/EMConfig.kt` | v1 | options `notRecognizedCredentialEvidence`, `notRecognizedUserAttribution` (default `false`) |
| `docs/options.md` | v1 | documentation of the two options (checked by EvoMaster's `ConfigToMarkdownTest`) |

## New files

| File | Patch | Content |
|---|---|---|
| `core-tests/e2e-tests/spring/spring-rest-openapi-v3/src/test/kotlin/org/evomaster/e2etests/spring/openapi/v3/security/notrecognized/SecurityNotRecognizedConfirmationEMTest.kt` | v1 | e2e test: EvoMaster's own `NotRecognizedApplication` with both rules on; the true fault must still be reported (adapted from the upstream `SecurityNotRecognizedEMTest`) |

Reused idioms (not copied code): the copy, `resetLocalIdRecursively` and
`addMainActionInEmptyEnterpriseGroup` pattern of upstream
`RestSecurityBuilder.handleCandidatesFor403`.
