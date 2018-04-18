package cn.eason.dao;

import cn.eason.domain.User;

import java.util.List;

/**
 *
 * @author Eason
 * @date Create in 17:59 18/04/2018
 */
public interface UserDao {

    User findUserById(int id);

    List<User> findUserByUserName(String name);

    void insertUser(User user);

    void updateUserById(int id);

    void deleteUserById(int id);

}
