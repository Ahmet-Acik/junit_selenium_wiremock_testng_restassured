package org.ahmet.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestsExampleTest {

    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana", "cherry"})
    void testWithValueSource(String fruit) {
        assertTrue(fruit.length() > 0);
    }
}