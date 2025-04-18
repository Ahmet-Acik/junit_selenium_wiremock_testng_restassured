package org.ahmet.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class ConditionalExecutionTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
//    @EnabledOnOs(OS.MAC)
    void testOnlyOnWindows() {
        System.out.println("This test runs only on Windows");
    }
}