package com.maksgir.webbackend.service;

import com.maksgir.webbackend.dto.PointDTO;

import java.util.List;


public interface PointService {
    PointDTO savePoint(PointDTO pointDTO, String username);
    List<PointDTO> getPointsByUsername(String username);

}
