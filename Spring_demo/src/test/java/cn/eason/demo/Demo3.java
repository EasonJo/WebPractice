package cn.eason.demo;

import cn.eason.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 19:05 16/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo3 {
//    @Resource(name = "loginServiceTarget")
//    private LoginService loginService;
    @Resource(name = "loginService")
    private LoginService loginService2;

   /* @Test
    public void fun1() {
        //对象不一样.
        System.out.println(loginService);
        System.out.println(loginService2);

        loginService.login();
    }*/

    @Test
    public void fun2() {
        loginService2.login();
    }
}
