package org.ahmet.restassured;

    import io.restassured.path.xml.XmlPath;
    import io.restassured.response.Response;
    import org.junit.jupiter.api.Order;
    import org.junit.jupiter.api.Test;
    import org.ahmet.restassured.models.Product;

    import java.io.File;
    import java.math.BigDecimal;

    import static io.restassured.RestAssured.given;
    import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
    import static org.assertj.core.api.Assertions.assertThat;

    /**
     * This class contains tests for REST-Assured tips related to product operations.
     * Each test demonstrates a specific feature or best practice of REST-Assured.
     */
    public class ProductTests extends BaseTest {

        private static final String PRODUCTS_ENDPOINT = "/products";

        /**
         * Tip 1: Configure REST-Assured to return BigDecimal instead of float or double.
         * Why: To avoid precision issues when working with monetary values.
         * How: Configure the JSON path to return numbers as BigDecimal using `.config()` and `.jsonConfig()`.
         */
        @Test
        @Order(1)
        public void testReturnBigDecimal() {
            Response response = given()
                    .spec(spec)
                    .config(io.restassured.config.RestAssuredConfig.config()
                            .jsonConfig(io.restassured.config.JsonConfig.jsonConfig()
                                    .numberReturnType(io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL)))
                    .get(PRODUCTS_ENDPOINT + "/1")
                    .then()
                    .statusCode(200)
                    .extract().response();

            BigDecimal price = response.path("price");
            assertThat(price).isInstanceOf(BigDecimal.class);
        }

        /**
         * Tip 3: Validate JSON Schema.
         * Why: To ensure the response structure matches the expected schema.
         * How: Use `.body(matchesJsonSchemaInClasspath())` to validate the response against a JSON schema file.
         */
        @Test
        @Order(2)
        public void testJsonSchemaValidation() {
            given()
                    .spec(spec)
                    .get(PRODUCTS_ENDPOINT + "/1")
                    .then()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("product-schema.json"));
        }

        /**
         * Tip 10: Automatic Serialization/Deserialization.
         * Why: To simplify handling of request and response payloads using POJOs.
         * How: Use `.body()` to serialize a POJO into JSON and `.as()` to deserialize the response into a POJO.
         */
        @Test
        @Order(3)
        public void testSerializationDeserialization() {
            Product product = new Product();
            product.setTitle("Serialized Product");
            product.setPrice(49.99f);
            product.setDescription("Description");
            product.setImage("https://i.pravatar.cc");
            product.setCategory("electronics");

            Response response = given()
                    .spec(spec)
                    .body(product)
                    .post(PRODUCTS_ENDPOINT)
                    .then()
                    .statusCode(200)
                    .extract().response();

            Product createdProduct = response.as(Product.class);
            assertThat(createdProduct.getTitle()).isEqualTo("Serialized Product");
        }

        /**
         * Tip 25: Extract Values from XML Response.
         * Why: To parse and validate XML responses using XML Path.
         * How: Use `XmlPath` to parse the XML response and extract specific values.
         */
        @Test
        @Order(4)
        public void testExtractXmlPath() {
            String xmlResponse = """
                    <product>
                        <id>1</id>
                        <title>Test Product</title>
                        <price>99.99</price>
                    </product>
                    """;

            XmlPath xmlPath = new XmlPath(xmlResponse);
            String title = xmlPath.getString("product.title");
            assertThat(title).isEqualTo("Test Product");
        }

        /**
         * Tip 35: Automatically Determine Parameter Type.
         * Why: To dynamically add query parameters based on the HTTP method.
         * How: Use `.queryParam()` to add query parameters to the request.
         */
        @Test
        @Order(5)
        public void testQueryParameters() {
            given()
                    .spec(spec)
                    .queryParam("limit", 5)
                    .get(PRODUCTS_ENDPOINT)
                    .then()
                    .statusCode(200);
        }

        /**
         * Tip 40: Replace Fixed Path Parameter Values.
         * Why: To make the endpoint dynamic and reusable.
         * How: Use `.pathParam()` to replace placeholders in the endpoint path.
         */
        @Test
        @Order(6)
        public void testPathParameters() {
            given()
                    .spec(spec)
                    .pathParam("id", 1)
                    .get(PRODUCTS_ENDPOINT + "/{id}")
                    .then()
                    .statusCode(200);
        }

        /**
         * Tip 20: Extract Values Using JSON Path.
         * Why: To retrieve specific fields from the JSON response.
         * How: Use `.path()` to extract values from the JSON response.
         */
        @Test
        @Order(7)
        public void testExtractJsonPath() {
            Response response = given()
                    .spec(spec)
                    .get(PRODUCTS_ENDPOINT + "/1")
                    .then()
                    .statusCode(200)
                    .extract().response();

            String title = response.path("title");
            assertThat(title).isNotEmpty();
        }

        /**
         * Tip 45: Specify a Cookie in the Request.
         * Why: To test endpoints that require cookies for authentication or session management.
         * How: Use `.cookie()` to add cookies to the request.
         */
        @Test
        @Order(8)
        public void testRequestWithCookie() {
            given()
                    .spec(spec)
                    .cookie("sessionId", "12345")
                    .get(PRODUCTS_ENDPOINT)
                    .then()
                    .statusCode(200);
        }

        /**
         * Tip 65: Measure Response Time.
         * Why: To monitor the performance of the API.
         * How: Use `.time()` to measure the response time of the request.
         */
        @Test
        @Order(9)
        public void testMeasureResponseTime() {
            long time = given()
                    .spec(spec)
                    .get(PRODUCTS_ENDPOINT)
                    .time();

            System.out.println("Response time: " + time + " ms");
        }

        /**
         * Tip 80: Send Multipart Form Data.
         * Why: To test file uploads or large data submissions.
         * How: Use `.multiPart()` to attach files and additional form data to the request.
         */
        @Test
        @Order(10)
        public void testMultipartFormData() {
            given()
                    .spec(spec)
                    .multiPart("file", new File("src/test/resources/test-file.txt"))
                    .multiPart("description", "Test file upload")
                    .post(PRODUCTS_ENDPOINT)
                    .then()
                    .statusCode(200);
        }

        /**
         * Tip 90: Use Filters.
         * Why: To inspect or modify requests and responses during execution.
         * How: Use `.filter()` to add custom logic for request/response processing.
         */
        @Test
        @Order(11)
        public void testRequestFilter() {
            given()
                    .spec(spec)
                    .filter((requestSpec, responseSpec, ctx) -> {
                        System.out.println("Request URI: " + requestSpec.getURI());
                        return ctx.next(requestSpec, responseSpec);
                    })
                    .get(PRODUCTS_ENDPOINT)
                    .then()
                    .statusCode(200);
        }

        /**
         * Tip 100: Relax SSL Validation.
         * Why: To bypass SSL validation for testing purposes.
         * How: Use `.relaxedHTTPSValidation()` to disable SSL validation.
         */
        @Test
        @Order(12)
        public void testRelaxedSSLValidation() {
            given()
                    .spec(spec)
                    .relaxedHTTPSValidation()
                    .get(PRODUCTS_ENDPOINT)
                    .then()
                    .statusCode(200);
        }
    }