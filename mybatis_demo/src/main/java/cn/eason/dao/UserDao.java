package cn.eason.dao;

import cn.eason.domain.QueryVo;
import cn.eason.domain.User;

import java.util.List;

/**
 * @author Eason
 * @date Create in 17:59 18/04/2018
 */
public interface UserDao {

    User findUserById(int id);

    List<User> getAllUsers();

    List<User> findUserByUserName(String name);

    List<User> findUserByQueryVo(QueryVo queryVo);

    void insertUser(User user);

    void updateUserById(int id);

    void deleteUserById(int id);

    int countUser();

    List<User> selectUserBySexAndUserName(User user);

    List<User> selectUserByIds(QueryVo queryVo);
//    List<User> selectUserByIds(Integer[] ids);

}
