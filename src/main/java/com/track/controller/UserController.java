package com.track.controller;

import org.springframework.stereotype.Controller;
import com.track.service.UserServiceImpl;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource(name = "userServiceImpl")
    UserServiceImpl userService;

    public void save(){
        userService.save();
    }

}
