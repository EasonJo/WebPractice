package cn.eason.springboot.service.impl;

import cn.eason.springboot.dao.UserMapper;
import cn.eason.springboot.domain.User;
import cn.eason.springboot.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eason
 * @date Create in 15:03 15/05/2018
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;


//    @Resource(name = "jedisCluster")
//    private JedisCluster jedisCluster;

    @Cacheable(value = "findAll")
    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

    @Override
    public Map<String, Object> redisMap() {
//        jedisCluster.set("user", "张三丰");
//        //设置完毕，获取之
//        String value = jedisCluster.get("user");
        Map<String, Object> maps = new HashMap<String, Object>();
        // maps.put("redis", value);
        return maps;
    }
}
