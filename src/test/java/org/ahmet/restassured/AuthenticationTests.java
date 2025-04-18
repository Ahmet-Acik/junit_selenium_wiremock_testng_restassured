package org.ahmet.restassured;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * This class contains tests for authentication mechanisms using REST-Assured.
 * Each test demonstrates a specific feature or best practice of REST-Assured for authentication.
 */
public class AuthenticationTests extends BaseTest {

    private static final String AUTH_ENDPOINT = "/auth/login";

    /**
     * Tip 13: Perform Basic Authentication.
     * Why: Basic authentication is a simple and widely used method for authenticating API requests.
     * How: Use the `.auth().preemptive().basic()` method to include the username and password in the request header.
     */
    @Test
    @Order(1)
    public void testBasicAuthentication() {
        given()
                .spec(spec) // Use the predefined request specification for consistent configuration.
                .auth().preemptive().basic("username", "password") // Add basic authentication credentials.
                .get(AUTH_ENDPOINT) // Send a GET request to the authentication endpoint.
                .then()
                .statusCode(200); // Assert that the response status code is 200 (OK).
    }

    /**
     * Tip 14: Authenticate with OAuth.
     * Why: OAuth 2.0 is a secure and modern standard for token-based authentication.
     * How: Use the `.auth().oauth2()` method to include the access token in the request header.
     */
    @Test
    @Order(2)
    public void testOAuthAuthentication() {
        given()
                .spec(spec) // Use the predefined request specification for consistent configuration.
                .auth().oauth2("access_token") // Add the OAuth 2.0 access token for authentication.
                .get(AUTH_ENDPOINT) // Send a GET request to the authentication endpoint.
                .then()
                .statusCode(200); // Assert that the response status code is 200 (OK).
    }
}