package cn.eason.springboot.controller;

import cn.eason.springboot.domain.User;
import cn.eason.springboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eason
 * @date Create in 14:37 15/05/2018
 */
@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("pojo")
    public User showUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("Eaosn");
        user.setAddress("beijing");
        user.setBirthDay(new Date());
        return user;
    }

    @GetMapping("maps")
    public Map<String, Object> showMaps() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "Eason");
        map.put("age", "32");
        return map;
    }

    @GetMapping("ssm")
    public List<User> showList() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "eason", new Date(), "beijing", "男"));
        users.add(new User(2, "xiaoyuer", new Date(), "beijing", "女"));
        return users;
    }

    @GetMapping("all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("userinfo/{id}")
    public User getUserInfo(@PathVariable("id") String id) {
        System.out.println(id);
        return showUser();
    }
}
