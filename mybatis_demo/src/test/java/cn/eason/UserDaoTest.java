package cn.eason;

import cn.eason.dao.UserDao;
import cn.eason.domain.QueryVo;
import cn.eason.domain.User;
import cn.eason.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Eason
 * @date Create in 10:36 19/04/2018
 */
public class UserDaoTest implements UserDao {
    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> findUserByUserName(String name) {
        return null;
    }

    @Override
    public List<User> findUserByQueryVo(QueryVo queryVo) {
        return null;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void updateUserById(int id) {

    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public int countUser() {
        return 0;
    }

    @Override
    public List<User> selectUserBySexAndUserName(User user) {
        return null;
    }

    @Override
    public List<User> selectUserByIds(QueryVo queryVo) {
        return null;
    }

    @Test
    public void count1User() {
        SqlSession sqlSession = MybatisUtils.openSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int cout = userDao.countUser();
        System.out.println(cout);
        sqlSession.close();
    }
}
