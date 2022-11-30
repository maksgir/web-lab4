package com.maksgir.webbackend.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AppController {

    @GetMapping("/hello")
    public String firstPage(){
        return "Hey body";
    }
}
