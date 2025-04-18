package org.ahmet.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CsvFileSourceExampleTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String name, int age) {
        assert name != null;
        assert age > 0;
        System.out.println(name + " is " + age + " years old");
    }
}