package com.maksgir.webbackend.service;

import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.entity.PointEntity;
import com.maksgir.webbackend.entity.UserEntity;
import com.maksgir.webbackend.repository.PointRepository;
import com.maksgir.webbackend.util.AreaHitChecker;
import com.maksgir.webbackend.util.PointsConverter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PointServiceImpl implements PointService {

    @Autowired
    private PointRepository repository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AreaHitChecker hitChecker;

    @Autowired
    private PointsConverter converter;


    @Override
    public PointDTO savePoint(PointDTO pointDTO, String username) {
        boolean hit = hitChecker.checkHit(pointDTO.getX(), pointDTO.getY(), pointDTO.getR());

        UserEntity user = userService.findUserBuUsername(username);

        PointEntity pointEntity = new PointEntity(
                pointDTO.getX(),
                pointDTO.getY(),
                pointDTO.getR(),
                LocalDateTime.now(),
                hit,
                user);

        PointEntity returnedEntity = repository.save(pointEntity);

        return converter.entityToDto(returnedEntity);

    }

    @Override
    public List<PointDTO> getPointsByUsername(String username) {
        UserEntity userEntity = userService.findUserBuUsername(username);
        List<PointEntity> pointEntityList = userEntity.getPoints();

        List<PointDTO> pointDTOList = new ArrayList<>();

        return null;
    }

}
