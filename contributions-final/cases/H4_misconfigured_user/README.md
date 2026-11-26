# Case H4: misconfigured user -- Rule 1 mechanism case

**Role.** Isolates Rule 1. The auth config has FOO (valid) and ZED, whose
credentials the API does not accept: a misconfigured user, the false-positive
source EvoMaster's own comment on the oracle mentions. ZED gets 401 on the
resource endpoints, which is correct. ZED also gets 200 on the public
`GET /api/catalog`, and that endpoint answers 403 to anyone for
`region=restricted`. EvoMaster 6.2.0 takes "ZED got a 2xx on an endpoint that
returned 403 to someone" as evidence that ZED is recognized and reports ZED's
401s. Rule 2 does not help (FOO gets 201/204/403 on the same requests, so the
401 is attributed to ZED); Rule 1 does (the same catalog request without
credentials still gets 200).

**Inputs.** `../a3_synthetic_app/app.py` with `CASE=H4`, `openapi.json`,
`em.yaml` (FOO and ZED). Written by us for A3.

**Expected.** No Not-Recognized fault. Replays H4-1..5.

**Predicted.** baseline: `PUT` and `GET /api/resources/{id}` reported (2 false
alarms); proto and rule1: not confirmed (950); rule2: both still reported.
