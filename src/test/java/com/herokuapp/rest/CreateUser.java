package com.herokuapp.rest;

import com.herokuapp.entity.address;
import com.herokuapp.entity.company;
import com.herokuapp.entity.geo;
import com.herokuapp.entity.payload;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class CreateUser {

    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }

    company com = new company("Test11","Test22","Test33");
    geo ge = new geo("24.10589","56.946");
    address add = new address("39, Villa street","street villa","riga","1033",ge);
    payload pay = new payload("258","testSer","testSer xxx","test.ser@gmail.com",add,"9876545633","www.ser.com",com);
    ObjectMapper objectMapper = new ObjectMapper() {
        public Object deserialize(ObjectMapperDeserializationContext objectMapperDeserializationContext) {
            return null;
        }

        public Object serialize(ObjectMapperSerializationContext objectMapperSerializationContext) {
            return objectMapperSerializationContext.getObjectToSerializeAs(payload.class);
        }
    };

    @Test
    public void postCreateUser_Serialize() {
        given()
                .contentType("application/json")
                .body(pay)
                .when()
                .post("/user")
                .then()
                .statusCode(201);
    }

    @Test
    public void verifyPostCreateExistinUser_Serialize() {
        given()
                .contentType("application/json")
                .body(pay)
                .when()
                .post("/user")
                .then()
                .statusCode(400);
    }


}
