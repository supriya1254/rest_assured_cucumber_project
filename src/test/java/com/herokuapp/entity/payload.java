package com.herokuapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class payload {
        private String id;
        private String name;
        private String userName;
        private String email;
        address address;
        private String phone;
        private String website;
        company company;
    }


