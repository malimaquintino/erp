package com.malimaquintino.erp.catalog;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductTypeIT {

    @LocalServerPort
    private int port;

    @Test
    public void shouldFindAllProductTypes() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.given()
                .basePath("/v1/product-type")
                .port(port)
                .accept(ContentType.JSON)
                .when().get()
                .then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldFindProductTypeById() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.given()
                .basePath("/v1/product-type/{id}")
                .pathParams("id", 1L)
                .port(port)
                .accept(ContentType.JSON)
                .when().get()
                .then().statusCode(HttpStatus.SC_OK);
    }
}
