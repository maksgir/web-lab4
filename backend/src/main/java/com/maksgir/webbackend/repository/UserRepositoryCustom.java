package com.maksgir.webbackend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface UserRepositoryCustom {
    void clearPoints(long id);
}
