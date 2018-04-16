package cn.eason.service.impl;

import cn.eason.bean.User;
import cn.eason.dao.UserDao;
import cn.eason.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Eason
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    private final UserDao userDao;

    @Resource(name = "user")
    private User user;

    @Autowired
    public LoginServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void login() {
        System.out.println("登录");
    }

    @Override
    public void loginOut() {
        System.out.println("登出");
    }

    @Override
    public void updateUser() {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser() {
        userDao.deleteUser(user);
    }
}
