package com.herokuapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    geo geo;
}
