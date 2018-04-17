package cn.eason.demo;

import cn.eason.bean.SpringUser;
import cn.eason.dao.SpringUserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @author Eason
 * @date Create in 10:15 17/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo_Jdbc {

    @Resource(name = "springDao")
    private SpringUserDao springUserDao;

    @Test
    public void fun1() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///hibernate");
        dataSource.setUser("pujl");
        dataSource.setPassword("102107");

        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.execute("INSERT INTO spring_user VALUES (NULL,'pujl',32)");
    }

    @Test
    public void insert() {
        SpringUser springUser = new SpringUser();
        springUser.setName("Lemon");
        springUser.setAge(30);

        springUserDao.insert(springUser);
    }

    @Test
    public void update() {
        SpringUser springUser = new SpringUser();
        springUser.setId(1);
        springUser.setName("小鱼儿");
        springUser.setAge(0);

        springUserDao.update(springUser);
    }


    @Test
    public void getALL(){
        List<SpringUser> list = springUserDao.getAll();
        System.out.println(list);
    }
}
