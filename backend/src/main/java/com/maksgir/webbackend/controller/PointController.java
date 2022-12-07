package com.maksgir.webbackend.controller;


import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.model.SimpleUser;
import com.maksgir.webbackend.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/point")
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping("/save")
    public void savePoint(@RequestBody PointDTO pointDTO, @AuthenticationPrincipal SimpleUser user){
        pointService.savePoint(pointDTO, user.getUsername());
    }
}
