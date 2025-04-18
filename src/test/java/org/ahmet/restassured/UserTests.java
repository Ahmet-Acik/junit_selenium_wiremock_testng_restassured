package org.ahmet.restassured;

    import io.restassured.response.Response;
    import org.junit.jupiter.api.Order;
    import org.junit.jupiter.api.Test;

    import static io.restassured.RestAssured.given;
    import static org.assertj.core.api.Assertions.assertThat;

    /**
     * This class contains tests for REST-Assured tips related to user operations.
     * Each test demonstrates a specific feature or best practice of REST-Assured.
     */
    public class UserTests extends BaseTest {

        private static final String USERS_ENDPOINT = "/users";

        /**
         * Tip 10: Set one or more headers in the request.
         * Why: To include additional information such as authentication tokens in the request.
         * How: Use `.header()` to add headers to the request.
         */
        @Test
        @Order(1)
        public void testRequestWithHeaders() {
            given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .header("Authorization", "Bearer token") // Add an Authorization header to the request.
                    .get(USERS_ENDPOINT) // Send a GET request to the users endpoint.
                    .then()
                    .statusCode(200); // Assert that the response status code is 200 (OK).
        }

        /**
         * Tip 11: Verify response data.
         * Why: To ensure the response contains the expected data.
         * How: Use `.path()` to extract specific fields from the response and validate them.
         */
        @Test
        @Order(2)
        public void testVerifyResponseData() {
            Response response = given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .get(USERS_ENDPOINT + "/1") // Send a GET request to retrieve a specific user.
                    .then()
                    .statusCode(200) // Assert that the response status code is 200 (OK).
                    .extract().response(); // Extract the response for further validation.

            String username = response.path("username"); // Extract the "username" field from the response.
            assertThat(username).isNotEmpty(); // Assert that the username is not empty.
        }

        /**
         * Tip 45: Specify a cookie in the request.
         * Why: To test endpoints that require cookies for authentication or session management.
         * How: Use `.cookie()` to add cookies to the request.
         */
        @Test
        @Order(3)
        public void testRequestWithCookie() {
            given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .cookie("sessionId", "12345") // Add a session cookie to the request.
                    .get(USERS_ENDPOINT) // Send a GET request to the users endpoint.
                    .then()
                    .statusCode(200); // Assert that the response status code is 200 (OK).
        }

        /**
         * Tip 40: Replace fixed path parameter values.
         * Why: To make the endpoint dynamic and reusable.
         * How: Use `.pathParam()` to replace placeholders in the endpoint path.
         */
        @Test
        @Order(4)
        public void testPathParameters() {
            given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .pathParam("id", 1) // Replace the {id} placeholder with a value.
                    .get(USERS_ENDPOINT + "/{id}") // Send a GET request to retrieve a specific user.
                    .then()
                    .statusCode(200); // Assert that the response status code is 200 (OK).
        }
    }