# crAPI (final project, held-out real target)

**Role.** Second real API, not used while developing the rules. It is one of the
eight vulnerable-by-design APIs in the RQ2 black-box experiments of the
baseline paper's extended version (Sahin, Zhang, Arcuri, arXiv:2604.00702,
Table 1: `crapi`, OWASP/crAPI, 44 endpoints, fuzzed through its gateway).

**Origin.** OWASP crAPI, tag `v1.1.6`, commit
`700f03d12a392d9e408260b4beae72ed02a4a1a4`, Docker images built from that commit, pinned by digest in `compose.pinned.yml` (the tag has no `1.1.6` image for most services)
(ids and digests: `environment/crapi_images.txt`). Unmodified; we start every
service in `deploy/docker/docker-compose.yml` except the chatbot (it needs an
OpenAI key, and it is not in the OpenAPI schema).

| File | Content |
|---|---|
| `crapi-openapi-spec.json` | crAPI's own schema from the tag (`openapi-spec/`), unchanged; 44 operations; sha256 `9dc66ecf…66bceb` |
| `em.yaml` | Auth config: seeded users `adam007@example.com` and `pogba006@example.com` (both `ROLE_PREDEFINE`), JWT from `POST /identity/api/auth/login` sent as `Authorization: Bearer` |

**Setup and reset.** `scripts/final_crapi.sh setup|up|reset|check|down`. The
database is deleted and re-seeded before every run (`reset`, about 2–3 min),
because crAPI has endpoints that change a user's email or password and would
otherwise leak state between runs.

**Expected result.** Not known in advance: crAPI is a held-out target. Each
Not-Recognized report (305 or 950) is labelled after the runs by reading the
source of the endpoint at the tag and replaying the request with curl as each
configured user and without a token (`notes/final_labels.md`). A report we
cannot label is counted as "unknown", not as correct.
