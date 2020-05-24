package com.herokuapp.rest;

import com.herokuapp.entity.address;
import com.herokuapp.entity.company;
import com.herokuapp.entity.geo;
import com.herokuapp.entity.payload;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class GetUser {
    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }

    company com = new company("Test11","Test22","Test33");
    geo ge = new geo("24.10589","56.946");
    address add = new address("39, Villa street","street villa","riga","1033",ge);
    payload pay = new payload("258","testSer","testSer xxx","test.ser@gmail.com",add,"9876545633","www.ser.com",com);

    @Test
    public void getUsersFindById_statusCode() {
        get("/users/findById/258").then().assertThat().statusCode(200);
    }

    @Test
    public void verifygetUsersFindById_statusCode() {
        get("/users/findById/6").then().assertThat().statusCode(404);
    }

    @Test
    public void getUsersFindById_contentType() {
        get("/users/findById/258").then().assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void getUsersFindById_userName() {
        String userName = pay.getUserName();
        get("/users/findById/258").then().assertThat().body("userName", is(userName));

    }

    @Test
    public void getAllUsers() {
        get("/users").then().assertThat().contentType(ContentType.JSON);
    }


}
