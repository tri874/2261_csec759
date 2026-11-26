"""
Final-project held-out synthetic cases H5, H6, H7 and H8 (one app, selected by CASE).

Written by us for the final project, after the A3 prototype was frozen
(patches/evomaster-v6.2.0-a3.patch + the D3 fix); not used to develop or tune
the rules. Labels and predictions were committed before any run
(notes/final_predictions.md). Users are identified by the Authorization
header, as in cases K and H1-H4.

  H5  second auth scheme, signalled. POST /api/reports answers 401 with
      "WWW-Authenticate: ApiKey" unless X-Api-Key is "r3p0rt" (the same key for
      every user). The users are recognized; the 401 asks for the second
      credential, which is correct (RFC 9110 15.5.2).               -> no fault
  H6  redirect login with a true fault. Requests without valid credentials
      are redirected to /login (302), never 401, like WebGoat. GET
      /api/billing answers 401 to FOO (a recognized user; should be 403) and
      200 to BAR.                                                   -> true fault
  H7  evidence through a creating POST. Items are created with POST
      /api/items (201 + Location); category "restricted" is refused with 403
      for everyone. GET /api/export answers 401 to FOO (recognized; should be
      403) and 200 to BAR.                                          -> true fault
  H8  three users, two denied by role. FOO, BAR and ADM are valid; DELETE
      /api/admin/cache answers 401 to FOO and BAR (recognized, not admins;
      should be 403) and 204 to ADM.                                -> true fault

Expected results are by construction; scripts/final_replays.sh checks them
with curl, independently of EvoMaster.
"""

import os

from flask import Flask, jsonify, redirect, request

CASE = os.environ.get("CASE", "")
if CASE not in ("H5", "H6", "H7", "H8"):
    raise SystemExit(f"set CASE to H5, H6, H7 or H8 (got '{CASE}')")

VALID_USERS = ("FOO", "BAR", "ADM") if CASE == "H8" else ("FOO", "BAR")
REPORT_KEY = "r3p0rt"

app = Flask(__name__)

# resource id -> user who created it. In memory: restarting resets the state.
data = {}
items = {}


def current_user():
    auth = request.headers.get("Authorization")
    return auth if auth in VALID_USERS else None


def not_authenticated():
    # H6 sends anonymous requests to a login page, like a form-login web app.
    if CASE == "H6":
        return redirect("/login", code=302)
    return "", 401, {"WWW-Authenticate": 'Bearer realm="api"'}


def parse_id(raw):
    try:
        return int(raw)
    except ValueError:
        return None


@app.route("/login", methods=["GET"])
def login_page():
    return "<html><body>login form</body></html>", 200, {"Content-Type": "text/html"}


# Resources owned by their creator; other users get 403 (as in case K). These
# endpoints give the Not-Recognized oracle its evidence.
@app.route("/api/resources/<raw_id>", methods=["PUT"])
def put_resource(raw_id):
    rid = parse_id(raw_id)
    if rid is None:
        return "", 400
    user = current_user()
    if user is None:
        return not_authenticated()
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
        return not_authenticated()
    if rid not in data or data[rid] != user:
        return "", 403
    return data[rid], 200, {"Content-Type": "text/plain"}


if CASE == "H5":
    @app.route("/api/reports", methods=["POST"])
    def reports():
        if current_user() is None:
            return not_authenticated()
        # Second credential, the same for every user: 401 is correct and says
        # which scheme is missing.
        if request.headers.get("X-Api-Key") != REPORT_KEY:
            return "", 401, {"WWW-Authenticate": 'ApiKey realm="reports"'}
        return "", 204


if CASE == "H6":
    @app.route("/api/billing", methods=["GET"])
    def billing():
        user = current_user()
        if user is None:
            return not_authenticated()
        # FOO is recognized but rejected with 401 (should be 403). True fault.
        if user == "FOO":
            return "", 401
        return jsonify({"user": user, "balance": 0}), 200


if CASE == "H7":
    @app.route("/api/items", methods=["POST"])
    def create_item():
        user = current_user()
        if user is None:
            return not_authenticated()
        body = request.get_json(silent=True) or {}
        category = str(body.get("category", ""))
        # Refused for everybody, whoever asks: a 403 that does not depend on the user.
        if category == "restricted":
            return "", 403
        iid = len(items) + 1
        items[iid] = {"owner": user, "category": category}
        return jsonify({"id": iid}), 201, {"Location": f"/api/items/{iid}"}

    @app.route("/api/items/<raw_id>", methods=["GET"])
    def get_item(raw_id):
        iid = parse_id(raw_id)
        if iid is None:
            return "", 400
        user = current_user()
        if user is None:
            return not_authenticated()
        if iid not in items:
            return "", 404
        if items[iid]["owner"] != user:
            return "", 403
        return jsonify(items[iid]), 200

    @app.route("/api/export", methods=["GET"])
    def export():
        user = current_user()
        if user is None:
            return not_authenticated()
        # FOO is recognized but rejected with 401 (should be 403). True fault.
        if user == "FOO":
            return "", 401
        return jsonify({"user": user, "rows": []}), 200


if CASE == "H8":
    @app.route("/api/admin/cache", methods=["DELETE"])
    def clear_cache():
        user = current_user()
        if user is None:
            return not_authenticated()
        # Only ADM has the admin role. FOO and BAR are recognized users, so
        # they should get 403. True fault for both.
        if user != "ADM":
            return "", 401
        return "", 204


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8083, threaded=True)
