# Case C: planned matched control (lesson cookie), not used

**Planned factor:** both users also send the JWT lesson's own credential, an
`access_token` cookie for lesson user Tom (`Cookie: access_token=<JWT>` as a
fixed header). Template: `environment/config/webgoat-em-c-cookie.template.yaml`;
diff vs P's config: [`auth-config.diff`](auth-config.diff). The run script
fetches a fresh token and writes the filled-in copy to
`environment/config/generated/` (not in git); the copy used is saved with the
run as `raw/a2_pilot/C/auth-config.yaml`.

**Why it was not used.** A rule was fixed before any run
(`notes/a2_predictions.md`, section C, commit `6236406`): if no `POST /JWT/votings/{title}` call returns
202 in the pilot's C run, the cookie does not reach WebGoat and the control
switches to C-alt. In the pilot (`raw/a2_pilot/C/`), the vote endpoint was
still reported and no vote call returned 202, although replay R4 shows the
same token turns the vote into 202 when sent with curl. EvoMaster 6.2.0 adds
login cookies with `builder.cookie(...)` and fixed headers with
`builder.header(...)` (`AuthUtils.kt` `addAuthHeaders`); the extra `Cookie`
header evidently does not reach WebGoat alongside the session cookie.

Check: `python3 scripts/a2_table.py --vote-accepted raw/a2_pilot/C/run_1; echo $?`
(1 = no vote call returned 202).

This is a limitation of how EvoMaster sends credentials, recorded here because
it decided the control; it is not part of the reported results.
