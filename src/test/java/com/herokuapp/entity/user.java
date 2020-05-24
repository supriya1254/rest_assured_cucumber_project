package com.herokuapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class user {
    private String id;
    private String name;
    private String userName;
    private String email;
    private String phone;
    private String website;
}
