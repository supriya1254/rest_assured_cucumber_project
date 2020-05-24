package com.herokuapp.rest;

import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class DeleteUser {

    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }

    @Test
    public void deleteExistingUserByuserName() {
        delete("/user/reskillUsernName21").then().assertThat().statusCode(204);
    }

    @Test
    public void verifydeleteExistingUserByuserName() {
        delete("/user/reskillUsernName21").then().assertThat().statusCode(404);
    }

    }

