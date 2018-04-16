package cn.eason.dao.impl;

import cn.eason.bean.User;
import cn.eason.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eason
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getAllUsers() {
        System.out.println("获取所有的用户");
        return null;
    }

    @Override
    public void insertUser(User user) {
        System.out.println("插入用户: " + user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("更新用户: " + user);
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("删除用户: " + user);
    }

}
