package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchMethod {

    @Test
    public void patchRequest() {

        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .patch("/api/users/2");
        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());
    }

}
