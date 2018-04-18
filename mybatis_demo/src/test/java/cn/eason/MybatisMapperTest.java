package cn.eason;

import cn.eason.dao.UserDao;
import cn.eason.domain.User;
import cn.eason.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Eason
 * @date Create in 18:20 18/04/2018
 */
public class MybatisMapperTest {

    @Test
    public void testMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(10);
        System.out.println(user);
    }
}
