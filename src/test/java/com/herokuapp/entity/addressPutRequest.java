package com.herokuapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class addressPutRequest {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
}
