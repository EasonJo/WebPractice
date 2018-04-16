package cn.eason.service.impl;

import cn.eason.bean.User;
import cn.eason.dao.UserDao;
import cn.eason.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Eason
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "user")
    private User user;

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
