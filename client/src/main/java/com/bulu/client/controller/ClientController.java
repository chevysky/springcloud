package com.bulu.client.controller;

import com.bulu.client.entity.UserInfo;
import com.bulu.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ClientController {

    @Autowired
    private ClientService client;

    @GetMapping("/hello")
    public String getMessage(String name, HttpServletRequest request)throws Exception{
        System.out.println("微服务接收调用地址" + request.getRequestURL());
        System.out.println("判断参数" + request.getAttribute("mark"));
        return client.getMessage(name);
    }

    @PostMapping("/map")
    public Map getMapInfo(@RequestBody Map map)throws Exception{
        map.put("response","info");
        return map;
    }

    @PostMapping("/user")
    public UserInfo getUserInfo(@RequestBody Map map)throws Exception{
        UserInfo user = new UserInfo();
        user.setName((String)map.get("key1"));
        user.setNickname((String)map.get("key2"));
        return user;
    }
}
