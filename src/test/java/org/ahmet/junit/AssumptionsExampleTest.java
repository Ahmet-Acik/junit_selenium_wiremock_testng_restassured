package org.ahmet.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

class AssumptionsExampleTest {

    @Test
    void testOnlyOnDevEnvironment() {
        assumeTrue("DEV".equals(System.getenv("DEV_ENV")),
                "Test can only run in DEV environment");
        System.out.println("Test executed in DEV environment");
    }
}