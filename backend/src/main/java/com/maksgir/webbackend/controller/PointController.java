package com.maksgir.webbackend.controller;


import com.maksgir.webbackend.aspect.Audited;
import com.maksgir.webbackend.dto.PointDTO;
import com.maksgir.webbackend.model.SimpleUser;
import com.maksgir.webbackend.service.PointService;
import com.maksgir.webbackend.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/points")
public class PointController {

    @Autowired
    private PointService pointService;


    @Autowired
    private UserServiceImpl userService;

    @Audited
    @GetMapping("/clear")
    public void clearPoints(@AuthenticationPrincipal SimpleUser user) {
        log.info("Clear request");
        userService.clearPoints(user.getUsername());
    }

    @Audited
    @GetMapping()
    public List<PointDTO> getPoints(@AuthenticationPrincipal SimpleUser user) {
        log.info("Get request");
        return pointService.getPointsByUsername(user.getUsername());
    }

    @Audited
    @PostMapping("/save")
    public PointDTO savePoint(@RequestBody PointDTO pointDTO, @AuthenticationPrincipal SimpleUser user) {
        log.info("Save request: " + pointDTO);
        return pointService.savePoint(pointDTO, user.getUsername());
    }
}
