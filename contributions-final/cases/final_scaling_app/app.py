"""
Generated scaling API (final project). The size is set by the environment:
E (number of protected endpoints) and U (number of configured users); the
behavior of each endpoint is defined in plan.py.
"""

import os

from flask import Flask, request

import plan

E = int(os.environ.get("E", "0"))
U = int(os.environ.get("U", "0"))
if E < 1 or U < 2:
    raise SystemExit(f"set E >= 1 and U >= 2 (got E={E}, U={U})")

VALID_USERS = set(plan.users(U))
FIRST_USER = plan.users(U)[0]

app = Flask(__name__)

# resource id -> user who created it. In memory: restarting resets the state.
data = {}


def current_user():
    auth = request.headers.get("Authorization")
    return auth if auth in VALID_USERS else None


def parse_id(raw):
    try:
        return int(raw)
    except ValueError:
        return None


@app.route("/api/resources/<raw_id>", methods=["PUT"])
def put_resource(raw_id):
    rid = parse_id(raw_id)
    if rid is None:
        return "", 400
    user = current_user()
    if user is None:
        return "", 401
    if rid not in data:
        data[rid] = user
        return "", 201
    if data[rid] != user:
        return "", 403
    return "", 204


@app.route("/api/resources/<raw_id>", methods=["GET"])
def get_resource(raw_id):
    rid = parse_id(raw_id)
    if rid is None:
        return "", 400
    user = current_user()
    if user is None:
        return "", 401
    if rid not in data or data[rid] != user:
        return "", 403
    return data[rid], 200, {"Content-Type": "text/plain"}


def make_handler(i, kind):
    def handler():
        user = current_user()
        if user is None:
            return "", 401
        if kind == "true" and user == FIRST_USER:
            return "", 401  # planted fault: a recognized user gets 401 (should be 403)
        if kind == "second" and request.headers.get("X-Api-Key") != plan.api_key(i):
            return "", 401  # second credential missing: 401 is correct
        return {"endpoint": i, "user": user}, 200
    handler.__name__ = f"e{i}"
    return handler


for index, path, endpoint_kind in plan.endpoints(E):
    app.add_url_rule(path, view_func=make_handler(index, endpoint_kind), methods=["GET"])


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8084, threaded=True)
