package org.ahmet.restassured;

    import org.junit.jupiter.api.Order;
    import org.junit.jupiter.api.Test;

    import static io.restassured.RestAssured.given;

    /**
     * This class contains tests for REST-Assured tips related to response validation.
     * Each test demonstrates a specific feature or best practice of REST-Assured.
     */
    public class ResponseValidationTests extends BaseTest {

        private static final String PRODUCTS_ENDPOINT = "/products";

        /**
         * Tip 30: Get headers, cookies, status line, and status code.
         * Why: To validate the response metadata such as headers and status code.
         * How: Use `.header()` to validate specific headers and `.statusCode()` to validate the status code.
         */
        @Test
        @Order(1)
        public void testResponseHeadersAndStatus() {
            given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .get(PRODUCTS_ENDPOINT + "/1") // Send a GET request to the products endpoint.
                    .then()
                    .statusCode(200) // Assert that the response status code is 200 (OK).
                    .header("Content-Type", "application/json; charset=utf-8"); // Validate the Content-Type header.
        }

        /**
         * Tip 65: Measure response time.
         * Why: To monitor the performance of the API.
         * How: Use `.time()` to measure the response time of the request.
         */
        @Test
        @Order(2)
        public void testMeasureResponseTime() {
            long time = given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .get(PRODUCTS_ENDPOINT) // Send a GET request to the products endpoint.
                    .time(); // Measure the response time.

            System.out.println("Response time: " + time + " ms"); // Print the response time.
        }
    }