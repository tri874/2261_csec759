# Final project: labels of the reports on the real targets

Machine-readable form: `final_labels.csv` (read by `scripts/final_table.py`).
Written after the runs (the real targets are held out; nothing was labelled
from EvoMaster's own verdict). Every endpoint that any configuration reported
with 305 or 950 is listed.

## crAPI v1.1.6 (`raw/final/*/crapi/`)

Across all 19 runs (baseline 5, proto 5, rule1 3, rule2 3, forkoff 3), the
only endpoint with a Not-Recognized report (305 or 950) is
`POST /identity/api/auth/login`.

**Label: no fault.** `AuthController.authenticateUser` (identity service,
tag v1.1.6) catches `BadCredentialsException` and answers `401` with
"invalid credentials". A wrong password is an authentication failure, so 401
is the correct code (RFC 9110 15.5.2), whoever sends it. The request carries
the configured user's token as well, but the login endpoint does not use it.

**Checked in the runs** (A3-DIAG lines, every run):
- baseline/forkoff evidence: the login endpoint itself (401 with a fuzzed
  body, 200 with the right one): the A2 "Y = X" pattern, on a second real API.
- Rule 1 finds genuine evidence: `PUT /workshop/api/shop/orders/1` gets 200 for
  adam and 401 when replayed without a token. So `rule1` keeps the false alarm.
- Rule 2 removes it: the same login request (same body) as pogba also gets 401.

No configuration reported any other crAPI endpoint, so the runs found no true
Not-Recognized fault in crAPI: recall on crAPI cannot be measured, only
precision (1 false alarm per baseline run, 0 for proto).

## WebGoat full API, 1 h (`raw/webgoat/` baseline from A1, `raw/final/proto/wgfull/`)

The five JWT-lesson endpoints, reported by the baseline in 10/10 runs and
downgraded by proto in 5/5. **Label: no fault**, from A2 (case P, replays
R1-R7, `cases/P_webgoat_jwt/README.md`): each 401 comes from the lesson's own
credential or input (cookie, Authorization header, body, query), and WebGoat
answers requests without a session with 302, never 401. No other endpoint was
reported by either configuration.
