package org.ahmet.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("custom")
@interface CustomTest {
}

class ComposedAnnotationTest {

    @CustomTest
    void testWithCustomAnnotation() {
        System.out.println("Custom annotation test executed");
    }
}