package cn.eason.dao;

import cn.eason.bean.User;

import java.util.List;

/**
 * @author Eason
 */
public interface UserDao {
    List<User> getAllUsers();

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
