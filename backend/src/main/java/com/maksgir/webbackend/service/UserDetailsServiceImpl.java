package com.maksgir.webbackend.service;


import com.maksgir.webbackend.config.Encoder;
import com.maksgir.webbackend.dto.UserDTO;
import com.maksgir.webbackend.entity.UserEntity;
import com.maksgir.webbackend.repository.UserRepository;
import com.maksgir.webbackend.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    protected UserRepository repository;

    @Autowired
    private Encoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = repository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public boolean existsByUsername(String name){
        return repository.existsByUsername(name);
    }

    public UserEntity save(UserDTO userDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        System.out.println(i1 + i2);
        return repository.save(newUser);
    }
}
