package cn.eason.springmvc;

import cn.eason.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Eason
 * @date Create in 13:55 19/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring_mybatis.xml"})
public class SpringWithMybatisTest {




    @Test
    public void testMapper() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_mybatis.xml");

        UserDao userDao = context.getBean(UserDao.class);


        int count = userDao.countUser();
        System.out.println(count);
    }
}
