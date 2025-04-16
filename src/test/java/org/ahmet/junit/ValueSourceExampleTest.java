package org.ahmet.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueSourceExampleTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testWithValueSource(int number) {
        assertTrue(number > 0 && number < 6);
    }
}