package com.maksgir.webbackend.service;

import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.entity.UserEntity;
import org.springframework.stereotype.Service;


public interface PointService {
    PointDTO savePoint(PointDTO pointDTO, String username);

}
