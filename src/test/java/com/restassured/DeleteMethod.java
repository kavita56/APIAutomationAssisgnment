package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteMethod {


    @Test
    public void deleteRequest() {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("Content-type", "application/json")
                .delete("/api/users/2");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.statusCode(),204,"Expected response code is 204 but found "+response.statusCode());
    }
}
