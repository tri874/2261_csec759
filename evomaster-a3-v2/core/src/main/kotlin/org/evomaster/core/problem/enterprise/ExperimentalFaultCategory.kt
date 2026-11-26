package org.evomaster.core.problem.enterprise

import com.webfuzzing.commons.faults.FaultCategory

enum class ExperimentalFaultCategory(
    private val code: Int,
    private val descriptiveName: String,
    private val testCaseLabel: String,
    private val fullDescription: String,
) : FaultCategory {

    //9xx for experimental, work-in-progress oracles


    //Implemented
    /*
        A3: a Not-Recognized candidate (configured user got a 401) that failed the confirmation
        rules enabled with notRecognizedCredentialEvidence / notRecognizedUserAttribution.
        Reported instead of SECURITY_NOT_RECOGNIZED_AUTHENTICATED, with lower confidence.
     */
    SECURITY_NOT_RECOGNIZED_UNCONFIRMED(950, "Unconfirmed 401 For Authenticated User", "returnsUnconfirmed401",
        "A configured user got a 401, but either there is no evidence that the user's credentials are " +
                "recognized by the API (the same successful request without credentials was not rejected with 401/403), " +
                "or the 401 cannot be attributed to the user (the same request as another configured user also got 401). " +
                "The 401 might be caused by other credentials or inputs in the request."),

    HTTP_TIMEOUT(960, "Request Timeout", "requestTimeout", "TODO"),


    /*
     TODO Is this one still relevant? or subsumed by SCHEMA_INVALID_RESPONSE?
     old comment was:
     syntactically invalid response (eg, non-quoted text when expecting JSON. this happens in pet-clinic for example)
  */
    HTTP_INVALID_PAYLOAD_SYNTAX(961, "Invalid Payload Syntax", "rejectedWithInvalidPayloadSyntax",
        "TODO"),


    //RPC
    // RPC internal error, eg thrift application internal error exception
    RPC_INTERNAL_ERROR(970, "Internal Error", "causesInternalError",
        "TODO"),
    // RPC service error which is customized by user
    RPC_SERVICE_ERROR(971, "Service Error", "causesServiceError",
        "TODO"),
    // exception for RPC
    RPC_DECLARED_EXCEPTION(972, "Declared Exception", "throwsExpectedException",
        "TODO"),
    // unexpected exception for RPC
    RPC_UNEXPECTED_EXCEPTION(973,"Unexpected Exception", "throwsUnexpectedException",
        "TODO"),
    // an RPC call which fails to achieve a successful business logic
    RPC_HANDLED_ERROR(974,"Business Logic Error", "failsToExecuteCall",
        "TODO"),

    //Web Frontend
    WEB_BROKEN_LINK(980, "Broken Link", "returnsBrokenLink",
        "TODO"),

    //mobile

    //GraphQL
    GQL_ERROR_FIELD(990, "Error Field", "returnedErrors",
        "TODO"),

    ;

    override fun getCode(): Int {
        return code
    }

    override fun getDescriptiveName(): String {
        return descriptiveName
    }

    override fun getTestCaseLabel(): String {
        return testCaseLabel
    }

    override fun getFullDescription(): String {
        return fullDescription
    }
}
