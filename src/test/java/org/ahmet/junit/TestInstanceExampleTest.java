package org.ahmet.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestInstanceExampleTest {

    private int counter = 0;

    @Test
    void test1() {
        counter++;
        System.out.println("Counter: " + counter);
    }

    @Test
    void test2() {
        counter++;
        System.out.println("Counter: " + counter);
    }
}