package cn.eason.service;

import cn.eason.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 15:56 19/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void getAllUsers() {
        List<User> users = userService.getAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
