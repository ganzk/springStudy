package com.ditest.controller;

import com.ditest.service.DIService;

public class DIController {

    DIService diService;

    public DIController(DIService diService) {
        this.diService = diService;
    }

    public void save(){
        diService.save();
    }

}
