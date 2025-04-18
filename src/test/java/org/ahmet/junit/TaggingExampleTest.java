package org.ahmet.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TaggingExampleTest {

    @Test
    @Tag("fast")
    void fastTest() {
        System.out.println("Fast test executed");
    }

    @Test
    @Tag("slow")
    void slowTest() {
        System.out.println("Slow test executed");
    }
}