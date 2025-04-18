package org.ahmet.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MethodSourceExampleTest {

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana", "cherry");
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithMethodSource(String fruit) {
        assert fruit != null;
        System.out.println(fruit);
    }
}