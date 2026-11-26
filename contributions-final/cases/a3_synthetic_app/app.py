"""
Assignment 3 synthetic cases H1, H1c, H2 and H4 (one app, selected by CASE).

Written by us for A3. The resource endpoints are the same as in case K
(cases/k_notrecognized/app.py, a port of EvoMaster's NotRecognizedApplication):
users are identified by the Authorization header, FOO and BAR are valid, a
resource belongs to the user who created it, and other users get 403. These
endpoints give EvoMaster's Not-Recognized oracle its evidence: a 2xx for the
user on an endpoint where someone got 403.

Each case adds one endpoint whose 401 has a known cause:

  H1   POST /api/vault          401 unless X-Api-Key is "k3y" (a second
                                credential, same for every user)    -> no fault
  H1c  POST /api/vault          401 for FOO whatever the key; BAR 204 (the
                                401 depends on the user only)       -> true fault
  H2   DELETE /api/admin/cache  401 for every valid user (only an admin role
                                may call it, and no admin is configured;
                                should be 403)                      -> true fault
  H4   GET /api/catalog         public; 403 for region=restricted, 200 otherwise.
                                The auth config has FOO and ZED, and ZED's
                                credentials are invalid (misconfigured user),
                                so ZED's 401s on the resources are correct
                                                                    -> no fault

Expected results are by construction; scripts/a3_replays.sh checks them with
curl, independently of EvoMaster.
"""

import os

from flask import Flask, request, jsonify

CASE = os.environ.get("CASE", "")
if CASE not in ("H1", "H1c", "H2", "H4"):
    raise SystemExit(f"set CASE to H1, H1c, H2 or H4 (got '{CASE}')")

VALID_USERS = ("FOO", "BAR")
API_KEY = "k3y"

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
    user = current_user()
    rid = parse_id(raw_id)
    if rid is None:
        return "", 400
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
    user = current_user()
    rid = parse_id(raw_id)
    if rid is None:
        return "", 400
    if user is None:
        return "", 401
    if rid not in data or data[rid] != user:
        return "", 403
    return data[rid], 200, {"Content-Type": "text/plain"}


if CASE in ("H1", "H1c"):
    @app.route("/api/vault", methods=["POST"])
    def vault():
        user = current_user()
        if user is None:
            return "", 401
        if CASE == "H1":
            # Second credential: the API key is checked for every user.
            # 401 is correct here (RFC 9110 15.5.2): the key is missing or wrong.
            if request.headers.get("X-Api-Key") != API_KEY:
                return "", 401
            return "", 204
        # H1c: the key is ignored; FOO is rejected with 401 although it is a
        # recognized user (should be 403). True Not-Recognized fault.
        if user == "FOO":
            return "", 401
        return "", 204


if CASE == "H2":
    @app.route("/api/admin/cache", methods=["DELETE"])
    def clear_cache():
        user = current_user()
        if user is None:
            return "", 401
        # Only an "admin" role may clear the cache, and neither FOO nor BAR has
        # it. Both are recognized users, so this should be 403. True fault.
        return "", 401


if CASE == "H4":
    @app.route("/api/catalog", methods=["GET"])
    def catalog():
        # Public endpoint: no credentials needed. One region is restricted for
        # everybody, which gives a 403 that does not depend on the user.
        region = request.args.get("region", "eu")
        if region == "restricted":
            return "", 403
        return jsonify({"region": region, "items": ["a", "b"]}), 200


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8082, threaded=True)
