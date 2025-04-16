package org.ahmet.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CommandLineParametersExampleTest {

    @Test
    @Parameters({"browser", "url"})
    public void testWithParameters(String browser, String url) {
        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);
    }
}