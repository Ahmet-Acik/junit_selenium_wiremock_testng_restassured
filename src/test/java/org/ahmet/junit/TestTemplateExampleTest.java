package org.ahmet.junit;

import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

class TestTemplateExampleTest {

    @TestTemplate
    @ExtendWith(CustomTestTemplateProvider.class)
    void testTemplateExample(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition: " + repetitionInfo.getCurrentRepetition());
    }
}