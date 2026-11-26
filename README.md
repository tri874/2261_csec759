# Reproducing EvoMaster on WebGoat

## Setup

- **WebGoat** runs as a Docker container. Pull the image and start it using the commands in [`environment/setup.md`](environment/setup.md).
- **EvoMaster** doesn't need to be pulled or deployed by hand. [`scripts/run_evomaster_webgoat.sh`](scripts/run_evomaster_webgoat.sh) takes care of it.

## Expected runtime

The paper ran EvoMaster 10 times against each API and limited every run to 1 hour. With the same setup:

- **Running the experiment:** about 10 hours in total
- **Consolidating the results:** a few minutes

## Outputs

| Output | What it contains |
|---|---|
| Kotlin test suites | Generated test files that show what EvoMaster found |
| Results JSON | The results of every test that was run |
| Python viewer scripts | Scripts that display the results JSON in a web browser on different operating systems |
| `summary.csv` | The metrics from the paper, defined below |

## Metrics

Every metric is a count. Each time a fault of that kind is found, its number goes up.

### Server and schema faults

| Metric | What it counts |
|---|---|
| **H500** | HTTP 500 faults, where the server crashed or threw an unhandled exception while responding |
| **Schema** | OpenAPI mismatch faults, where a response doesn't match the provided schema |

### Access-control faults

| Metric | Fault | What it counts |
|---|---|---|
| **Leakage** | Fault800 | Information disclosure, where a user without permission gets a 404 for a resource instead of a 403 |
| **Not-Recognized** | Fault801 | A logged-in user gets a 401 when a 403 would have been more appropriate |
| **Missed-Check** | Fault802 | A user is correctly blocked (403) from one kind of change to a resource but allowed (2xx) to make a different kind of change to the same resource. For example, DELETE is blocked but PATCH goes through, or the other way around. |

## Known limitations

The paper doesn't say which versions of EvoMaster, the WebGoat API, Docker or the other technologies were used. This reproduction uses the latest stable version of each, so they probably don't match the versions the authors used.