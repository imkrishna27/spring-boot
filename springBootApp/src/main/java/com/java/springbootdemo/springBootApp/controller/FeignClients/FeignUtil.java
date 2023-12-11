package com.java.springbootdemo.springBootApp.controller.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "json-placeholder", url = "https://jsonplaceholder.typicode.com")
public interface FeignUtil {
    @RequestMapping(method = RequestMethod.GET, value = "/comments")
    public String getComments();
}
