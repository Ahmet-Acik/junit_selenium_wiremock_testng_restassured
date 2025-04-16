package org.ahmet.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayNameExampleTest {

    @Test
    @DisplayName("Test addition of two numbers")
    void testAddition() {
        assertEquals(2, 1 + 1);
    }
}