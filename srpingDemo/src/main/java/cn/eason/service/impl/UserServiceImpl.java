package cn.eason.service.impl;

import cn.eason.dao.UserDao;
import cn.eason.domain.User;
import cn.eason.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 15:49 19/04/2018
 */
@Transactional(transactionManager = "transactionManager", isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED,
    readOnly = false, rollbackFor = Exception.class)
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;


    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        System.out.println(userDao);
        return userDao.getAllUsers();
    }
}
