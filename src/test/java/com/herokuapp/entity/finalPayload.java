package com.herokuapp.entity;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class finalPayload {
    public static void main(String[] args) {

        company com = new company("Test11","Test22","Test33");
        geo ge = new geo("24.10589","56.946");
        address add = new address("39, Villa street","street villa","riga","1033",ge);
        payload pay = new payload("258","Krishika","Krishika God","Krishika.god@gmail.com",add,"9877654345","www.god.com",com);
        System.out.println(pay);
        ObjectMapper objectMapper = new ObjectMapper() {
            public Object deserialize(ObjectMapperDeserializationContext objectMapperDeserializationContext) {
                return null;
            }

            public Object serialize(ObjectMapperSerializationContext objectMapperSerializationContext) {
                return objectMapperSerializationContext.getObjectToSerializeAs(payload.class);
            }
        };


    }
}
