package com.maksgir.webbackend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends UserRepositoryCustom, UserRepositoryJpa{
}
