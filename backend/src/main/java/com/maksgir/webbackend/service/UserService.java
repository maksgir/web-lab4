package com.maksgir.webbackend.service;

import com.maksgir.webbackend.entity.UserEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends UserDetailsServiceImpl {

    public void clearPoint(String username) {
        UserEntity user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No such user with username: " + username));
        repository.clearPoints(user.getId());
    }
}
