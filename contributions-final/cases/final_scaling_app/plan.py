"""
Plan of the generated scaling API (final project, scalability experiment).

Shared by the app (app.py) and the generator (scripts/final_gen_scaling.py),
so the served behavior, the OpenAPI schema and the labels always agree. No
third-party imports.

Parameters: E protected endpoints GET /api/e<i> (i = 0..E-1) and U configured
users U0..U<U-1>, identified by the Authorization header. Every request
without a valid user gets 401. On top of that:

  i % 5 == 0  "true"     U0 gets 401, the other users 200. U0 is recognized
                         elsewhere, so this should be 403: a planted true
                         Not-Recognized fault (like H1c).
  i % 5 == 1  "second"   every user gets 401 unless X-Api-Key is "k<i>" (a
                         second credential, the same for everyone; like H1).
                         The 401 is correct: no fault.
  otherwise   "plain"    every user gets 200: no fault.

So 20% of the endpoints carry a true fault and 20% a second credential.
PUT/GET /api/resources/{id} (owned by the creator, 403 for other users, as in
case K) give the Not-Recognized oracle its evidence in every configuration.
"""


def users(u):
    return [f"U{k}" for k in range(u)]


def kind(i):
    if i % 5 == 0:
        return "true"
    if i % 5 == 1:
        return "second"
    return "plain"


def endpoints(e):
    """[(index, path, kind)] for the E protected endpoints."""
    return [(i, f"/api/e{i}", kind(i)) for i in range(e)]


def api_key(i):
    return f"k{i}"


def expected_faults(e):
    """Operation names ("GET:/api/e<i>") that carry a true Not-Recognized fault."""
    return sorted(f"GET:{p}" for _, p, k in endpoints(e) if k == "true")
