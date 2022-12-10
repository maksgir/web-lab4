package com.maksgir.webbackend.controller;


import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.model.SimpleUser;
import com.maksgir.webbackend.service.PointService;
import com.maksgir.webbackend.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/points")
public class PointController {

    @Autowired
    private PointService pointService;


    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/clear")
    public void clearPoints(@AuthenticationPrincipal SimpleUser user){
        userService.clearPoints(user.getUsername());
    }

    @PostMapping("/save")
    public void savePoint(@RequestBody PointDTO pointDTO, @AuthenticationPrincipal SimpleUser user){
        pointService.savePoint(pointDTO, user.getUsername());
    }
}
