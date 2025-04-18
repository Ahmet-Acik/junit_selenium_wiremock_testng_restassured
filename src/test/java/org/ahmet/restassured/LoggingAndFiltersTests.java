package org.ahmet.restassured;

    import org.junit.jupiter.api.Order;
    import org.junit.jupiter.api.Test;

    import java.io.File;

    import static io.restassured.RestAssured.given;

    /**
     * This class contains tests for logging and filters using REST-Assured.
     * Each test demonstrates a specific feature or best practice of REST-Assured for logging and request/response filtering.
     */
    public class LoggingAndFiltersTests extends BaseTest {

        private static final String PRODUCTS_ENDPOINT = "/products";

        /**
         * Tip 18: Log requests and responses.
         * Why: To debug and inspect the details of requests and responses during test execution.
         * How: Use `.log().all()` to log all details of the request and response.
         */
        @Test
        @Order(1)
        public void testLoggingRequestsAndResponses() {
            given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .log().all() // Log all details of the request.
                    .get(PRODUCTS_ENDPOINT) // Send a GET request to the products endpoint.
                    .then()
                    .log().all() // Log all details of the response.
                    .statusCode(200); // Assert that the response status code is 200 (OK).
        }

        /**
         * Tip 80: Send multipart form data.
         * Why: To test file uploads or large data submissions.
         * How: Use `.multiPart()` to attach files and additional form data to the request.
         */
        @Test
        @Order(2)
        public void testMultipartFormData() {
            given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .multiPart("file", new File("src/test/resources/test-file.txt")) // Attach a file to the request.
                    .multiPart("description", "Test file upload") // Add additional form data.
                    .post(PRODUCTS_ENDPOINT) // Send a POST request to the products endpoint.
                    .then()
                    .statusCode(200); // Assert that the response status code is 200 (OK).
        }

        /**
         * Tip 90: Use Filters.
         * Why: To inspect or modify requests and responses during execution.
         * How: Use a custom filter to log the request URI and proceed with the request.
         */
        @Test
        @Order(3)
        public void testRequestFilter() {
            given()
                    .spec(spec) // Use the predefined request specification for consistent configuration.
                    .filter((requestSpec, responseSpec, ctx) -> {
                        System.out.println("Request URI: " + requestSpec.getURI()); // Log the request URI.
                        return ctx.next(requestSpec, responseSpec); // Proceed with the request.
                    })
                    .get(PRODUCTS_ENDPOINT) // Send a GET request to the products endpoint.
                    .then()
                    .statusCode(200); // Assert that the response status code is 200 (OK).
        }
    }