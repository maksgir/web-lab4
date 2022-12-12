package com.maksgir.webbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PointDTO {
    private double x;
    private double y;
    private double r;
    private LocalDateTime dt;
    private boolean hit;
}
