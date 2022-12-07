package com.maksgir.webbackend.config;

import com.maksgir.webbackend.model.SimpleUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class BearerAuthToken extends AbstractAuthenticationToken {
    private SimpleUser principal;

    public BearerAuthToken(SimpleUser user) {
        super(Collections.emptyList());
        this.principal = user;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
