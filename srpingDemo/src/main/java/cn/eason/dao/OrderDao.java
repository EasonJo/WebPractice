package cn.eason.dao;

import cn.eason.domain.Orders;
import cn.eason.domain.User;

import java.util.List;

/**
 * @author Eason
 * @date Create in 11:30 19/04/2018
 */
public interface OrderDao {
    List<Orders> getOrders();

    /**
     * 获取完整的订单,其中包含了用户信息
     *
     * @return
     */
    List<Orders> getCompleteOrders();

    /**
     * 获取所有的用户信息,其中包含了用户关联的订单信息
     *
     * @return
     */
    List<User> getAllUsers();

    void doxxx();
}
