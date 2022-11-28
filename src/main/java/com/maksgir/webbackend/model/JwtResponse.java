package com.maksgir.webbackend.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class JwtResponse implements Serializable {
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}
