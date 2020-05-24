package com.herokuapp.rest;

import com.herokuapp.entity.addressPutRequest;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class UpdateUser {
    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }

    addressPutRequest add = new addressPutRequest("40, Villa street","street villa","riga","1033");

    ObjectMapper objectMapper = new ObjectMapper() {
        public Object deserialize(ObjectMapperDeserializationContext objectMapperDeserializationContext) {
            return null;
        }

        public Object serialize(ObjectMapperSerializationContext objectMapperSerializationContext) {
            return objectMapperSerializationContext.getObjectToSerializeAs(addressPutRequest.class);
        }
    };


    @Test
    public void putAddOrUpdateExtUser_Serialize() {
        given()
                .contentType("application/json")
                .body(add)
                .when()
                .put("/user/Krishika God/address")
                .then()
                .statusCode(204);
    }

    @Test
    public void verifyPutAddOrUpdateExtUser_Serialize() {
        given()
                .contentType("application/json")
                .body(add)
                .when()
                .put("/user//address")
                .then()
                .statusCode(400);
    }

    @Test
    public void verifyMandatoryField() {
        given()
                .contentType("application/json")
                .body(add)
                .when()
                .put("/user/Krishika God/address")
                .then()
                .statusCode(400);
    }
}
