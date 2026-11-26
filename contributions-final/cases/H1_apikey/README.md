# Case H1: second credential (API key) -- additional variant

**Role.** Tests the rule beyond the primary input. Unlike WebGoat, the main
login answers 401 (not a redirect) to anonymous requests, so the Not-Recognized
oracle's evidence that FOO is recognized is genuine. The false alarm can only
come from the other half of the A2 failure: a 401 caused by a second credential
attributed to the configured user. Rule 2 must catch it; Rule 1 alone should not.

**What differs from P.** Target (our app instead of WebGoat), login style
(fixed `Authorization` header, 401 when missing), and the second credential is a
header declared in the schema (`X-Api-Key`, example `k3y`) instead of the JWT
lesson's cookies, headers and bodies.

**Inputs.** `../a3_synthetic_app/app.py` with `CASE=H1`, `openapi.json`,
`em.yaml` (users FOO and BAR). Written by us for A3.

**Expected.** No Not-Recognized fault. `POST /api/vault` answers 401 to every
user whose `X-Api-Key` is wrong and 204 to FOO with the right key: the 401 is
about the key (RFC 9110 §15.5.2). Replays H1-1..5 (`scripts/a3_replays.sh`).

**Predicted.** baseline: vault reported (false alarm); proto: not confirmed
(950); rule1: still reported; rule2: not confirmed.
