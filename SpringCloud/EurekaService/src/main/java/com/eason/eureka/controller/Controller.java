package com.eason.eureka.controller;

import com.eason.eureka.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 16:52 16/05/2018
 */
@RestController
public class Controller {

    @Resource(name = "userService")
    private UserService userService;


    @GetMapping("user")
    public String showUser() {
        return userService.getUserInfo("eason");
    }


    @GetMapping("test")
    public String fun1() {
        return userService.test();
    }

}
