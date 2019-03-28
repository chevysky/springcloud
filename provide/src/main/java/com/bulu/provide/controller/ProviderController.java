package com.bulu.provide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("hello")
    public String getMessage(String name){
        return "hello my ".concat(name);
    }
}
