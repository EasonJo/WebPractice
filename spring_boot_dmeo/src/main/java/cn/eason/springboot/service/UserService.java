package cn.eason.springboot.service;

import cn.eason.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author Eason
 * @date Create in 15:01 15/05/2018
 */
public interface UserService {
    List<User> findAll();

    Map<String, Object> redisMap();
}
