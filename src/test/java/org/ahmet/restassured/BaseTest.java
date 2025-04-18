package org.ahmet.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    protected static RequestSpecification spec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
        spec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setContentType(io.restassured.http.ContentType.JSON)
                .build();
    }
}