package org.ahmet.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisabledTestExampleTest {

    @Test
    @Disabled("Disabled until bug #123 is fixed")
    void testDisabled() {
        System.out.println("This test is disabled");
    }
}