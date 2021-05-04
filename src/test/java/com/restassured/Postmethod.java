package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Postmethod {
    @Test
    public void testmethod1()
    {
        RestAssured.baseURI= "https://reqres.in/";
        String reqbody =
                "  {\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}";
        Response response= given().
                header("content-type","application/json").
                body(reqbody).post("/api/users");
        Assert.assertEquals(response.statusCode(),201,"Expected response code is 201 but found "+response.statusCode());
        String postresponse = response.jsonPath().get().toString();
        System.out.println(postresponse);
    }
    @Test
    public void testmethod2()
    {
        RestAssured.baseURI= "https://reqres.in/";
        String reqbody =
                "  \n" +
                        "{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}";
        Response response= given().
                header("content-type","application/json").
                body(reqbody).post("/api/register");
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());
        String postresponse = response.jsonPath().get().toString();
        System.out.println(postresponse);
    }
    @Test
    public void testmethod3()
    {
        RestAssured.baseURI= "https://reqres.in/";
        String reqbody =
                "  {\n" +
                        "    \"email\": \"sydney@fife\"\n" +
                        "}";
        Response response= given().
                header("content-type","application/json").
                body(reqbody).post("/api/register");
        Assert.assertEquals(response.statusCode(),400,"Expected response code is 400 but found "+response.statusCode());
        String postresponse = response.jsonPath().get().toString();
        System.out.println(postresponse);
    }
    @Test
    public void testmethod4()
    {
        RestAssured.baseURI= "https://reqres.in/";
        String reqbody =
                "  {\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}";
        Response response= given().
                header("content-type","application/json").
                body(reqbody).post("/api/login");
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());
        String postresponse = response.jsonPath().get().toString();
        System.out.println(postresponse);
    }
    @Test
    public void testmethod5()
    {
        RestAssured.baseURI= "https://reqres.in/";
        String reqbody =
                "  {\n" +
                        "    \"email\": \"peter@klaven\"\n" +
                        "}";
        Response response= given().
                header("content-type","application/json").
                body(reqbody).post("/api/login");
        Assert.assertEquals(response.statusCode(),400,"Expected response code is 400 but found "+response.statusCode());
        String postresponse = response.jsonPath().get().toString();
        System.out.println(postresponse);
    }
}
