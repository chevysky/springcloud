package com.bulu.feign.controller;

import com.bulu.feign.rpc.RemoteCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FeignController {

    @Autowired
    private RemoteCall remote;

    @GetMapping("feign")
    public String getMessage(String name)throws Exception{
        return remote.getMessage(name);
    }

    @GetMapping("map")
    public Map getMapInfo()throws Exception{
        Map map = new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
       return remote.getMapInfo(map);
    }

    @GetMapping("user")
    public Map getUserInfo()throws Exception{
        Map map = new HashMap();
        map.put("key1","阿黄");
        map.put("key2","小黄");
        return remote.getUserInfo(map);
    }
}
