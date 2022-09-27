package com.springboot.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String userMailId;
    private String userPassword;


}