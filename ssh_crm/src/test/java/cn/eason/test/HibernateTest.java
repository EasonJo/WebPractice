package cn.eason.test;

import cn.eason.domain.User;
import cn.eason.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 11:07 18/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Test
    public void testDb() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        User u = new User();
        u.setUser_name("肉丝");
        u.setUser_code("rose");
        u.setUser_password("1234");
        u.setUser_state('c');

        session.save(u);

        tx.commit();

        session.close();
        sf.close();
    }

    @Test
    public void testSpringSessionFactory(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User u = new User();
        u.setUser_name("杰克");
        u.setUser_code(" jack");
        u.setUser_password("1234");
        u.setUser_state('c');

        session.save(u);

        tx.commit();

        session.close();
    }

    @Test
    public void testQuery(){
        User u = new User();
        u.setUser_name("杰克");
        u.setUser_code(" jack");
        u.setUser_password("1234");
        u.setUser_state('c');
       User user = userService.getUserByCode(u);
        System.out.println(user);
    }

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void testTx(){
        User u = new User();
        u.setUser_name("Eaosn");
        u.setUser_code("pujl");
        u.setUser_password("1234");
        u.setUser_state('c');

        userService.saveUser(u);
    }
}
