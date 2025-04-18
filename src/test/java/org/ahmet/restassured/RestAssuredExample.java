package org.ahmet.restassured;

            import io.restassured.RestAssured;

            import static io.restassured.RestAssured.given;
            import static io.restassured.config.JsonConfig.jsonConfig;
            import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

            /**
             * This class demonstrates basic usage of REST-Assured for making HTTP requests.
             * Each section highlights a specific tip or best practice.
             */
            public class RestAssuredExample {

                /**
                 * Tip 1: Configure REST-Assured to return BigDecimal instead of float or double.
                 * Why: To avoid precision issues when working with monetary or large numerical values.
                 * How: Use `.jsonConfig()` to configure the JSON path to return numbers as BigDecimal.
                 */
                public static void main(String[] args) {
                    RestAssured.config = RestAssured.config()
                        .jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL)); // Configure JSON path to return BigDecimal.

                    /**
                     * Tip 15: Validate the response status code.
                     * Why: To ensure the API returns the expected HTTP status code.
                     * How: Use `.statusCode()` in the response validation chain.
                     */
                    given()
                        .when()
                        .get("https://api.example.com/data") // Send a GET request to the specified endpoint.
                        .then()
                        .statusCode(200); // Assert that the response status code is 200 (OK).
                }
            }