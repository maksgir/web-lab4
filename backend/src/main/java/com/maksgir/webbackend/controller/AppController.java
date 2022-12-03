package com.maksgir.webbackend.controller;


import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.service.PointService;
import com.maksgir.webbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private PointService pointService;

    @GetMapping("/hello")
    public String firstPage(){
        return "Hey body";
    }

    @GetMapping("clear")
    public void clearPoints(@AuthenticationPrincipal UserDetails details){
        userService.clearPoint(details.getUsername());
    }

    @PostMapping
    public void savePoint(@RequestBody PointDTO pointDTO, @AuthenticationPrincipal UserDetails details){

    }


}
