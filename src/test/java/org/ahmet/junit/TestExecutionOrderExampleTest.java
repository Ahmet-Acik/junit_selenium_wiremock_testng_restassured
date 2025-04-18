package org.ahmet.junit;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestExecutionOrderExampleTest {

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Second test executed");
    }

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("First test executed");
    }
}