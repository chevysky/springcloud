package com.bulu.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AdminController {

    @Autowired
    private RestTemplate rest;

    @GetMapping("admin")
    public String getMessage(String name)throws Exception{
        return rest.getForObject("http://CLIENT/hello?name=".concat(name),String.class);
    }
}
