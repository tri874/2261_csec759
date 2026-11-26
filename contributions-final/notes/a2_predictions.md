# Assignment 2 predictions

Recorded before any Assignment 2 run (see the git history of this file).
Case definitions are in `ASSIGNMENT2_PLAN.md`, section 5.

All EvoMaster runs: EvoMaster 6.2.0 (pinned digest), black-box, seeds 1–3,
5 minutes per run. WebGoat runs use `--endpointPrefix /JWT`.

The 5 Not-Recognized (code 305) endpoints from the A1 baseline:

1. `GET:/WebGoat/JWT/votings/login`
2. `POST:/WebGoat/JWT/votings/{title}`
3. `POST:/WebGoat/JWT/refresh/login`
4. `POST:/WebGoat/JWT/refresh/newToken`
5. `POST:/WebGoat/JWT/refresh/checkout`

## K — known working example (EvoMaster's NotRecognized test app, ported)

- Expected (ground truth): one true Not-Recognized fault, `POST:/api/resources/`
  for user FOO.
- Prediction: reported in all 3 runs; nothing else reported as Not-Recognized.

## P — primary failed case (WebGoat JWT lesson)

- Expected (ground truth): no Not-Recognized fault.
- Prediction: all 5 endpoints above reported in all 3 runs (false alarms).

## C — matched control

The pilot decides which version is run; both are predicted here.

**C (cookie):** both users also send `Cookie: access_token=<JWT for lesson user Tom>`.
Used if the pilot shows `POST /JWT/votings/{title}` returning 202 in this
configuration (the extra cookie reaches WebGoat).

- Expected: no Not-Recognized fault.
- Prediction: `POST:/WebGoat/JWT/votings/{title}` is no longer reported. The
  other 4 are still reported: `votings/login` and `refresh/login` reject
  lesson-level login inputs, and `refresh/newToken` and `refresh/checkout`
  need the `Authorization` header, which this configuration does not add.

**C-alt (Authorization header):** both users also send
`Authorization: Bearer a2-control`. Used if the cookie does not reach WebGoat.

- Expected: no Not-Recognized fault.
- Prediction: `POST:/WebGoat/JWT/refresh/checkout` is no longer reported (any
  `Authorization` value turns its 401 into 200). The other 4 are still
  reported: `refresh/newToken` still rejects the body's refresh token,
  `votings/{title}` still lacks the `access_token` cookie, and the two
  lesson logins still reject their inputs.

## V — additional variant (exclude `GET /JWT/votings/login`)

- Expected: no Not-Recognized fault.
- Prediction: `votings/{title}`, `refresh/login` and `refresh/newToken` are no
  longer reported, because in the baseline their "this endpoint requires a
  login" evidence came only from `GET /JWT/votings/login`.
  `refresh/checkout` is still reported (it serves as its own evidence:
  401 without the header, 200 with a junk one). `votings/login` itself
  cannot be reported because it is excluded.
- Alternative outcome we would not be surprised by: some of the three are
  still reported, with `refresh/checkout` supplying the evidence instead. That
  would extend the explanation: any endpoint with an input-dependent 401 can
  act as the evidence.

## Deterministic replays (curl, one run each)

| ID | Request | Prediction |
|---|---|---|
| R1 | `POST /WebGoat/JWT/votings/a2`, no session | 302 |
| R2 | same, userA session | 401 |
| R3 | same, userB session | 401 |
| R4 | same, userA session + `access_token` from `GET /WebGoat/JWT/votings/login?user=Tom` | 202 |
| R5a | `GET /WebGoat/JWT/votings/login?user=Tom`, userA session | 200 |
| R5b | `GET /WebGoat/JWT/votings/login?user=zzz`, userA session | 401 |
| R6a | `POST /WebGoat/JWT/refresh/checkout`, userA session, no `Authorization` | 401 |
| R6b | same, with `Authorization: Bearer a2-control` | 200 |
| R7a | K: `POST /api/resources/` as FOO | 401 |
| R7b | K: same as BAR | 204 |
| R7c | K: same, no `Authorization` | 401 |

## V2 — follow-up variant (added after the full run of V, before V2 ran)

The full run of V matched the alternative outcome above: with
`GET /JWT/votings/login` excluded, `POST /JWT/refresh/checkout` supplied the
"requires a login" evidence (same user: 401 without an `Authorization`
header, 200 with a junk one). V2 tests that extended explanation by removing
both endpoints whose 401 depends on the request's inputs and that also give
the same user a 2xx.

- Setup: as P, plus `--endpointExclude /JWT/votings/login,/JWT/refresh/checkout`.
- Expected: no Not-Recognized fault.
- Prediction: **no** Not-Recognized reports. The remaining 401s
  (`votings/{title}`, `refresh/login`, `refresh/newToken`) are still there,
  but no remaining JWT endpoint gives the same user both a 401/403 and a 2xx,
  so the oracle has no "requires a login" evidence (WebGoat answers 302, not
  401, to requests without a session).
- If some are still reported, the evidence came from an endpoint we have not
  identified; the call sequences in the results table will show which.
