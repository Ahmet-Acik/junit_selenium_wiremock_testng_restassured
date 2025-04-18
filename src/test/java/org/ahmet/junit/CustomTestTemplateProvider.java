package org.ahmet.junit;

import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import java.util.stream.Stream;

class CustomTestTemplateProvider implements TestTemplateInvocationContextProvider {

    @Override
    public boolean supportsTestTemplate(org.junit.jupiter.api.extension.ExtensionContext context) {
        return true; // Always supports the test template
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(
            org.junit.jupiter.api.extension.ExtensionContext context) {
        return Stream.of(
                invocationContext("First invocation"),
                invocationContext("Second invocation")
        );
    }

    private TestTemplateInvocationContext invocationContext(String name) {
        return new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return name;
            }
        };
    }
}