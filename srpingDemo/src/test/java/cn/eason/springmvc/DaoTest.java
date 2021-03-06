package cn.eason.springmvc;

import cn.eason.dao.UserDao;
import cn.eason.domain.User;
import cn.eason.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 12:03 20/04/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring_mybatis.xml","classpath:spring_mvc.xml"})
public class DaoTest {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    public void getAllUsers() {
        List<User> users = userService.getAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void test() {
        int count = userDao.countUser();
        System.out.println("hello" + count);
    }


}
