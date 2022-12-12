package com.maksgir.webbackend.util;

import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.entity.PointEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PointsConverter {

    public PointDTO entityToDto(PointEntity entity){

        PointDTO dto = new PointDTO();
        dto.setX(entity.getX());
        dto.setY(entity.getY());
        dto.setR(entity.getR());
        dto.setDt(entity.getDt());
        dto.setHit(entity.isHit());

        return dto;
    }

    public PointEntity dtoToEntity(PointDTO dto){

        return new PointEntity(
                dto.getX(),
                dto.getY(),
                dto.getR());
    }
}
