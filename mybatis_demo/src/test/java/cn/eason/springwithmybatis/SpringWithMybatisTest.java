package cn.eason.springwithmybatis;

import cn.eason.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eason
 * @date Create in 13:55 19/04/2018
 */
public class SpringWithMybatisTest {
    @Test
    public void testMapper() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean(UserDao.class);


        int count = userDao.countUser();
        System.out.println(count);
    }
}
