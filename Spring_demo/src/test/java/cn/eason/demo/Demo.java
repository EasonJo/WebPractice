package cn.eason.demo;

import cn.eason.bean.User;
import cn.eason.dao.LinkManDao;
import cn.eason.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    @Test
    public void fun() {
        //获取 SpringContext 全局容器类
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
        applicationContext.close();
    }

    @Test
    public void fun2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user2");
        System.out.println(user);
    }

    @Test
    public void fun3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.getAllUsers();
        LinkManDao linkManDao = (LinkManDao) context.getBean("linkManDao");
        linkManDao.create();
    }
}
