package org.ahmet.junit;

import org.junit.jupiter.api.RepeatedTest;

class RepeatedTestExampleTest {

    @RepeatedTest(3)
    void repeatedTest() {
        System.out.println("Repeated test executed");
    }
}