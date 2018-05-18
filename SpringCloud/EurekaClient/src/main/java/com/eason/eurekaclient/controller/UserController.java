package com.eason.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eason
 * @date Create in 16:17 16/05/2018
 */
@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    @GetMapping("hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
}
