package org.ahmet.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class TimeoutExampleTest {

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testWithTimeout() throws InterruptedException {
        // Simulate a long-running task
//        Thread.sleep(2000); // Fails
        Thread.sleep(500); // Passes
    }
}