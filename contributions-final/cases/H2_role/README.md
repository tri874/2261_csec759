# Case H2: role-restricted endpoint -- tradeoff check

**Role.** The case where Rule 2 is expected to lose a true fault (recall cost,
planned in A2's proposal). `DELETE /api/admin/cache` is meant for an admin role
that no configured user has, and it answers 401 to FOO and BAR although both
are recognized (they create and read resources); 403 is correct. Because every
configured user gets the same 401, Rule 2 cannot attribute it to a user.

**Inputs.** `../a3_synthetic_app/app.py` with `CASE=H2`, `openapi.json`,
`em.yaml` (FOO and BAR). Written by us for A3.

**Expected.** True fault: `DELETE /api/admin/cache`. Replays H2-1..4.

**Predicted.** baseline: reported; proto: downgraded to 950 (missed as a
confirmed fault, but still in the output with lower confidence).
