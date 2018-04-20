package cn.eason;

import cn.eason.dao.OrderDao;
import cn.eason.domain.Orders;
import cn.eason.domain.User;
import cn.eason.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Eason
 * @date Create in 12:00 19/04/2018
 */
public class OrderDaoTest {

    @Test
    public void getAllOrders() {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Orders> orders = orderDao.getOrders();

        for (Orders order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void getOrdersWithUser() {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Orders> orders = orderDao.getCompleteOrders();
        for (Orders o : orders) {
            System.out.println(o);
        }
    }


    @Test
    public void getAllUsers() {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<User> users = orderDao.getAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
