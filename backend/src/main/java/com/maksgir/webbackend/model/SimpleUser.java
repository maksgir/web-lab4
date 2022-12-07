package com.maksgir.webbackend.model;

import lombok.Getter;

@Getter
public class SimpleUser {
    private String username;

    public SimpleUser(String username) {
        this.username = username;
    }
}
