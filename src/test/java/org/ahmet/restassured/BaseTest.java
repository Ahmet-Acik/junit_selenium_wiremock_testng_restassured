package org.ahmet.restassured;

                import io.restassured.RestAssured;
                import io.restassured.builder.RequestSpecBuilder;
                import io.restassured.specification.RequestSpecification;
                import org.junit.jupiter.api.BeforeAll;

                /**
                 * BaseTest class provides a common setup for REST-Assured tests.
                 * It initializes a reusable RequestSpecification to ensure consistent configuration across all tests.
                 */
                public abstract class BaseTest {

                    // A static RequestSpecification object to be shared across all test classes.
                    protected static RequestSpecification spec;

                    /**
                     * Tip: Centralize configuration for REST-Assured.
                     * Why: To avoid duplicating setup code in every test class and ensure consistency.
                     * How: Use a @BeforeAll method to initialize a RequestSpecification with common settings.
                     */
                    @BeforeAll
                    public static void setup() {
                        // Set the base URI for all API requests.
                        RestAssured.baseURI = "https://fakestoreapi.com";

                        // Build a RequestSpecification with the base URI and default content type.
                        spec = new RequestSpecBuilder()
                                .setBaseUri(RestAssured.baseURI) // Set the base URI for the API.
                                .setContentType(io.restassured.http.ContentType.JSON) // Set the default content type to JSON.
                                .build();
                    }
                }