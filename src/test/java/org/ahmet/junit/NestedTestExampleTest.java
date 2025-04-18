package org.ahmet.junit;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestedTestExampleTest {

    @Nested
    class InnerTest {

        @Test
        void innerTest() {
            System.out.println("Inner test executed");
        }
    }
}