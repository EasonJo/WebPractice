package com.eason.eureka.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 16:41 16/05/2018
 */
@Service("userService")
public class UserService {

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    public String getUserInfo(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String test(){
        return "hello world!";
    }
}
