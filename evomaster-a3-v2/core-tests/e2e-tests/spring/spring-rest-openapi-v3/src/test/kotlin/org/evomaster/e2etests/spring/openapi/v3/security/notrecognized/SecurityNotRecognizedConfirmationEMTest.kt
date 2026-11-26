package org.evomaster.e2etests.spring.openapi.v3.security.notrecognized

import com.foo.rest.examples.spring.openapi.v3.security.notrecognized.NotRecognizedController
import com.webfuzzing.commons.faults.DefinedFaultCategory
import org.evomaster.core.problem.enterprise.DetectedFaultUtils
import org.evomaster.core.problem.rest.data.HttpVerb
import org.evomaster.e2etests.spring.openapi.v3.SpringTestBase
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * A3: same as [SecurityNotRecognizedEMTest], but with both Not-Recognized confirmation rules enabled.
 * The fault in NotRecognizedApplication (POST 401 for FOO, while FOO is recognized on PUT/GET)
 * is a true fault, so it must still be reported as SECURITY_NOT_RECOGNIZED_AUTHENTICATED.
 */
class SecurityNotRecognizedConfirmationEMTest : SpringTestBase(){

    companion object {
        @BeforeAll
        @JvmStatic
        fun init() {
            initClass(NotRecognizedController())
        }
    }


    @Test
    fun testRunEM() {

        runTestHandlingFlakyAndCompilation(
            "SecurityNotRecognizedConfirmationEM",
            200
        ) { args: MutableList<String> ->

            setOption(args, "security", "true")
            setOption(args, "schemaOracles", "false")
            setOption(args, "httpOracles", "false")
            setOption(args, "statusOracles", "false")
            setOption(args, "notRecognizedCredentialEvidence", "true")
            setOption(args, "notRecognizedUserAttribution", "true")

            val solution = initAndRun(args)

            assertTrue(solution.individuals.size >= 1)

            assertHasAtLeastOne(solution, HttpVerb.POST, 401, "/api/resources/", null)

            val faults = DetectedFaultUtils.getDetectedFaultCategories(solution)

            assertTrue(faults.contains(DefinedFaultCategory.SECURITY_NOT_RECOGNIZED_AUTHENTICATED), "Faults: $faults")
        }
    }
}
