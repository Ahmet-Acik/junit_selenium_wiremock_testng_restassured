package org.ahmet.restassured;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

public class RestAssuredExample {

    public static void main(String[] args) {
        RestAssured.config = RestAssured.config()
            .jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL));

        given()
            .when()
            .get("https://api.example.com/data")
            .then()
            .statusCode(200);
    }
}