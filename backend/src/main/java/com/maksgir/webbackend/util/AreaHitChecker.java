package com.maksgir.webbackend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaHitChecker {
    public boolean checkHit(double x, double y, double r) {
        boolean triangle_hit = (x <= 0 && x >= -r / 2) && (y <= x + r / 2) && (y >= 0 && y <= r / 2);
        boolean circle_hit = ((x * x + y * y) <= r * r / 4) && (x <= 0 && x >= -r / 2) && (y <= 0 && y >= -r / 2);
        boolean square_hit = (x >= 0 && x <= r) && (y <= 0 && y >= -r / 2);

        return triangle_hit || circle_hit || square_hit;
    }
}