package com.maksgir.webbackend.controller;


import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.entity.UserEntity;
import com.maksgir.webbackend.service.UserServiceImpl;
import com.maksgir.webbackend.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AppController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PointService pointService;

    @GetMapping("/hello")
    public String firstPage(){
        return "Hey body";
    }

    @GetMapping("/clear")
    public void clearPoints(@AuthenticationPrincipal UserDetails details){
        userService.clearPoints(details.getUsername());
    }

    @PostMapping()
    public void savePoint(@RequestBody PointDTO pointDTO, @AuthenticationPrincipal UserDetails details){
        UserEntity user = userService.findUserBuUsername(details.getUsername());
        pointService.savePoint(pointDTO, user);
    }


}
