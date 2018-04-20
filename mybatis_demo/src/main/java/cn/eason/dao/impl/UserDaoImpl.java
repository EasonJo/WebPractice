package cn.eason.dao.impl;

import cn.eason.dao.UserDao;
import cn.eason.domain.QueryVo;
import cn.eason.domain.User;
import cn.eason.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author Eason
 * @date Create in 17:59 18/04/2018
 */

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl() {
        sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
    }

    @Override
    public User findUserById(int id) {
        //auto commit session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("findUserById", id);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> findUserByUserName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> user = sqlSession.selectList("findUserByUserName", name);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByQueryVo(QueryVo queryVo) {
        return null;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("insertUser", user);
    }

    @Override
    public void updateUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("updateUserById", id);
    }

    @Override
    public void deleteUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("deleteUserById", id);
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
}
