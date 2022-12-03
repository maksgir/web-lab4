package com.maksgir.webbackend.service;

import com.maksgir.webbackend.dto.UserDTO;
import com.maksgir.webbackend.entity.UserEntity;

public interface UserService {
    void clearPoints(String username);
    UserEntity saveUser(UserDTO userDTO);
    boolean existsByUsername(String username);
    UserEntity findUserBuUsername(String username);
}
