package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod {
    @Test
    public void testMethod1() {

        Response response=given().
                header("content-type","application/json").
                get("https://reqres.in/api/users/2");
        System.out.println("*** "+response.asString()+" ***");
       Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void testMethod2() {

        Response response=given().
                header("content-type","application/json").
                get("https://reqres.in/api/users?delay=3");
        System.out.println("*** "+response.asString()+" ***");
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void testMethod3() {

        Response response=given().
                header("content-type","application/json").
                get("https://reqres.in/api/users?page=2");
        System.out.println("*** "+response.asString()+" ***");
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void testMethod4() {
        RestAssured.baseURI= "https://reqres.in";
        Response response=given().
                header("content-type","application/json").
                get("/api/users/23");
        System.out.println("*** "+response.asString()+" ***");
        Assert.assertEquals(response.statusCode(),404,"Expected response code is 404 but found "+response.statusCode());

    }
    @Test
    public void testMethod5() {
        RestAssured.baseURI= "https://reqres.in";
        Response response=given().
                header("content-type","application/json").
                get("/api/unknown");
        System.out.println("*** "+response.asString()+" ***");
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void testMethod6() {
        RestAssured.baseURI= "https://reqres.in";
        Response response=given().
                header("content-type","application/json").
                get("/api/unknown/2");
        System.out.println("*** "+response.asString()+" ***");
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void testMethod7() {
        RestAssured.baseURI= "https://reqres.in";
        Response response=given().
                header("content-type","application/json").
                get("/api/unknown/23");
        System.out.println("*** "+response.asString()+" ***");
        Assert.assertEquals(response.statusCode(),404,"Expected response code is 404 but found "+response.statusCode());

    }

}
