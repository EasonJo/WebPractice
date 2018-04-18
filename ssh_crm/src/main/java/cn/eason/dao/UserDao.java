package cn.eason.dao;

import cn.eason.domain.User;

/**
 * @author Eason
 * @date Create in 13:02 18/04/2018
 */
public interface UserDao {
    User findUser(String uName);

    void saveUser(User user);

}
