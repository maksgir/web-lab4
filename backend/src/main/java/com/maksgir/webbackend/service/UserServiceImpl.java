package com.maksgir.webbackend.service;


import com.maksgir.webbackend.config.Encoder;
import com.maksgir.webbackend.dto.UserDTO;
import com.maksgir.webbackend.entity.UserEntity;
import com.maksgir.webbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

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

    @Override
    public boolean existsByUsername(String name) {
        return repository.existsByUsername(name);
    }

    @Override
    public UserEntity findUserBuUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    @Override
    public UserEntity saveUser(UserDTO userDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        newUser.setPoints(new ArrayList<>());
        return repository.save(newUser);
    }


    @Override
    public void clearPoints(String username) {
        UserEntity user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No such user with username: " + username));
        System.out.println("Clearing points of user:" + username);
        repository.clearPoints(user.getId());
    }
}
