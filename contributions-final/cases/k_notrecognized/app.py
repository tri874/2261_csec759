"""
Case K: known working example for the Not-Recognized oracle.

Python/Flask port of EvoMaster's own end-to-end test application
NotRecognizedApplication.kt (EvoMaster v6.2.0, LGPL-3.0):
core-tests/e2e-tests/spring/spring-rest-openapi-v3/src/main/kotlin/com/foo/
rest/examples/spring/openapi/v3/security/notrecognized/NotRecognizedApplication.kt

It is the scenario of the ISSRE 2025 paper's Figure 1: users FOO and BAR are
both recognized (they can create and read resources), but POST /api/resources/
answers 401 to FOO instead of 403. That 401 is a true Not-Recognized fault.

Differences from the original, none of which touch the oracle's logic:
  - A missing Authorization header returns 401 (Spring would return 400 for a
    missing required header before the handler runs).
  - A non-integer {id} returns 400, as Spring's path conversion does.
"""

from flask import Flask, request

app = Flask(__name__)

# resource id -> user who created it. In memory, so restarting the container
# resets the state between runs.
data = {}


def check_auth(auth):
    return auth in ("FOO", "BAR")


def parse_id(raw):
    try:
        return int(raw)
    except ValueError:
        return None


@app.route("/api/resources/<raw_id>", methods=["PUT"])
def put_resource(raw_id):
    auth = request.headers.get("Authorization")
    rid = parse_id(raw_id)
    if rid is None:
        return "", 400
    if not check_auth(auth):
        return "", 401
    if rid not in data:
        data[rid] = auth
        return "", 201
    if data[rid] != auth:
        return "", 403
    return "", 204


@app.route("/api/resources/<raw_id>", methods=["GET"])
def get_resource(raw_id):
    auth = request.headers.get("Authorization")
    rid = parse_id(raw_id)
    if rid is None:
        return "", 400
    if not check_auth(auth):
        return "", 401
    if rid not in data:
        return "", 403
    if data[rid] != auth:
        return "", 403
    return data[rid], 200, {"Content-Type": "text/plain"}


@app.route("/api/resources/", methods=["POST"])
def only_bar():
    auth = request.headers.get("Authorization")
    if auth != "BAR":
        # Wrong on purpose: FOO is a recognized user and should get 403.
        return "", 401
    return "", 204


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8081, threaded=True)
