package com.maksgir.webbackend.service;

import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.entity.PointEntity;
import com.maksgir.webbackend.entity.UserEntity;
import com.maksgir.webbackend.repository.PointRepository;
import com.maksgir.webbackend.util.AreaHitChecker;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public class PointServiceImpl {

    @Autowired
    private PointRepository repository;

    private AreaHitChecker hitChecker;


    public void save(PointDTO pointDTO) {

//        boolean hit = hitChecker.checkHit(pointDTO.getX(), pointDTO.getY(), pointDTO.getR());
//
//        UserEntity userEntity = pointBean.getUserBean().getUserEntity();
//        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
//
//        PointEntity pointEntity =  (pointBean.getType().equals("Павук"))? new SpiderPoint():new AntPoint();
//        pointEntity.setX(pointBean.getX());
//        pointEntity.setY(pointBean.getY());
//        pointEntity.setR(pointEntity.getR());
//        pointEntity.setDt(ldt);
//        pointEntity.setExe_time(exeTime);
//        pointEntity.setHit(hit);
//        pointEntity.setOwner(userEntity);
//
//        if (pointEntity instanceof SpiderPoint){
//            ((SpiderPoint) pointEntity).setLegNum(dataGenerator.getLegs());
//        } else {
//            ((AntPoint) pointEntity).setBodyColor(dataGenerator.getColor());
//        }
//
//
//        PointDTO pointDTO = new PointDTO(pointBean.getX(), pointBean.getY(),
//                pointBean.getR(), ldt, exeTime, hit, pointBean.getType());
//
//        dao.save(pointEntity);
//
//        pointBean.getUserBean().getPointDTOList().add(pointDTO);
    }
}
