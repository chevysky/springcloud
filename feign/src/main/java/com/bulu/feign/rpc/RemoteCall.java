package com.bulu.feign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Repository
@FeignClient(value = "client")
@ResponseBody
public interface RemoteCall {

    @GetMapping(value = "/hello?name={name}")
    String getMessage(@PathVariable("name") String name)throws Exception;

    @PostMapping(value = "/map")
    Map getMapInfo(Map map)throws Exception;

    @PostMapping(value = "/user")
    Map getUserInfo(Map map)throws Exception;
}
