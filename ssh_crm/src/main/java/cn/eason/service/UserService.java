package cn.eason.service;

import cn.eason.domain.User;

/**
 * @author Eason
 * @date Create in 10:06 18/04/2018
 */
public interface UserService {

    User getUserByCode(User user);

    void saveUser(User user);
}
