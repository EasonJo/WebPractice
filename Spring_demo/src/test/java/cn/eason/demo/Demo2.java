package cn.eason.demo;

import cn.eason.dao.UserDao;
import cn.eason.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Eason PU
 * @date  Create in 17:44 16/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo2 {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "loginService")
    private LoginService loginService;

    @Test
    public void fun1() {
        loginService.login();
    }

    @Test
    public void fun2() {
        loginService.updateUser();
    }
}
