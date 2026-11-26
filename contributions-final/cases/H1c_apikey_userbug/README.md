# Case H1c: matched control of H1

**Role.** Same app, same schema, same users and budget as H1; one factor
changed: what the vault's 401 depends on. Here `POST /api/vault` ignores the key
and rejects FOO with 401 while BAR gets 204, so the 401 depends on the user
only and FOO, recognized on the resource endpoints, should have got 403. The
trigger of the H1 false alarm (a 401 caused by another credential) is gone.

**Inputs.** `../a3_synthetic_app/app.py` with `CASE=H1c`, `openapi.json`
(identical to H1's apart from the title), `em.yaml` (identical to H1's).
Written by us for A3.

**Expected.** True fault: `POST /api/vault` for FOO. Replays H1c-1..4.

**Predicted.** Reported by baseline and kept (305) by proto.
