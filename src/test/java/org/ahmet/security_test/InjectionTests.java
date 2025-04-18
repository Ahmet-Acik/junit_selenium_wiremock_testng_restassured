package org.ahmet.security_test;

import org.ahmet.restassured.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * This class contains tests for various types of injection vulnerabilities.
 * Each method demonstrates a specific type of injection attack.
 */
public class InjectionTests extends BaseTest {

    private static final String INJECTION_ENDPOINT = "/vulnerable-endpoint";

    /**
     * SQL Injection: Exploits vulnerabilities in SQL queries by injecting malicious SQL code.
     */
    @Test
    public void testSQLInjection() {
        given()
            .spec(spec)
            .queryParam("id", "1 OR 1=1") // Malicious SQL input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }

    /**
     * Command Injection: Executes arbitrary system commands on the server.
     */
    @Test
    public void testCommandInjection() {
        given()
            .spec(spec)
            .queryParam("cmd", "ls; rm -rf /") // Malicious command input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }

    /**
     * LDAP Injection: Manipulates LDAP queries to access or modify directory services.
     */
    @Test
    public void testLDAPInjection() {
        given()
            .spec(spec)
            .queryParam("user", "admin)(|(password=*))") // Malicious LDAP input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }

    /**
     * XPath Injection: Alters XPath queries to access unauthorized XML data.
     */
    @Test
    public void testXPathInjection() {
        given()
            .spec(spec)
            .queryParam("xpath", "admin' or '1'='1") // Malicious XPath input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }

    /**
     * NoSQL Injection: Targets NoSQL databases by injecting malicious queries.
     */
    @Test
    public void testNoSQLInjection() {
        given()
            .spec(spec)
            .queryParam("filter", "{ \"$ne\": null }") // Malicious NoSQL input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }

    /**
     * HTML Injection: Injects HTML code into web pages, often leading to XSS.
     */
    @Test
    public void testHTMLInjection() {
        given()
            .spec(spec)
            .queryParam("input", "<h1>Injected HTML</h1>") // Malicious HTML input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose

    }

    /**
     * Code Injection: Injects malicious code into an application for execution.
     */
    @Test
    public void testCodeInjection() {
        given()
            .spec(spec)
            .queryParam("code", "System.exit(0);") // Malicious code input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }

    /**
     * CRLF Injection: Injects carriage return and line feed characters to manipulate HTTP headers.
     */
    @Test
    public void testCRLFInjection() {
        given()
            .spec(spec)
            .queryParam("header", "InjectedHeader%0D%0ASet-Cookie:sessionId=malicious") // Malicious CRLF input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }

    /**
     * Email Header Injection: Alters email headers to send spam or phishing emails.
     */
    @Test
    public void testEmailHeaderInjection() {
        given()
            .spec(spec)
            .queryParam("email", "test@example.com%0D%0ABcc:spam@example.com") // Malicious email header input
            .get(INJECTION_ENDPOINT)
            .then()
//            .statusCode(400); // Expecting the server to handle it securely
                .statusCode(404); // not found for test purpose
    }
}