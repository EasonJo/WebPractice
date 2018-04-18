package cn.eason.service.impl;

import cn.eason.dao.UserDao;
import cn.eason.domain.User;
import cn.eason.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 10:08 18/04/2018
 */
@Service("userService")
@Transactional(transactionManager = "transactionManager", isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED,
    rollbackFor = Exception.class, readOnly = true)
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public User getUserByCode(User user) {
        User u = userDao.findUser(user.getUser_code());
        if (u == null) {
            throw new RuntimeException("用户名不存在");
        }

        if (!u.getUser_password().equals(user.getUser_password())) {
            throw new RuntimeException("密码错误!");
        }

        return u;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
