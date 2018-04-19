package cn.eason;

import cn.eason.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author Eason
 * @date Create in 15:22 18/04/2018
 */
public class MybatisTest {

    @Test
    public void testMybatis() throws IOException {
        //加载核心配置文件

        InputStream configuration = Resources.getResourceAsStream("sqlMapConfig.xml");

        //创建 sql Session Factory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //获取 Session
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("user.findUserById", 10);
        System.out.println(user);

        //关闭 session
        session.close();
        //关闭工厂
    }

    @Test
    public void findUserByUserName() throws IOException {
        InputStream configuration = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建 sql Session Factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //获取 Session
        SqlSession session = sqlSessionFactory.openSession();

        List<User> userList = session.selectList("user.findUserByUserName", "五");

        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test
    public void insertUser() throws IOException {
        InputStream configuration = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建 sql Session Factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //获取 Session
        SqlSession session = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("Eason");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京");

        int id = session.insert("user.insertUser", user);

        session.commit();

        System.out.println(user);
    }

    @Test
    public void updateUserById() throws IOException {
        InputStream configuration = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建 sql Session Factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //获取 Session
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(27);
        user.setUsername("Eason");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("四川");

        session.update("user.updateUserById", user);
    }

    @Test
    public void deleteUserById() throws IOException {
        InputStream configuration = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建 sql Session Factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //获取 Session
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("user.deleteUserById", 27);
    }

}
