package com.itheima.service.impl;

import com.itheima.dao.AdminDao;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.AdminService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {

    @Override
	public List<Category> findAllCategory() {
        AdminDao dao = new AdminDao();
        try {
            return dao.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
	public void saveProduct(Product product) throws SQLException {
        AdminDao dao = new AdminDao();
        dao.saveProduct(product);
    }

    @Override
	public List<Order> findAllOrders() {
        AdminDao dao = new AdminDao();
        List<Order> ordersList = null;
        try {
            ordersList = dao.findAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
	public List<Map<String, Object>> findOrderInfoByOid(String oid) {
        AdminDao dao = new AdminDao();
        List<Map<String, Object>> mapList = null;
        try {
            mapList = dao.findOrderInfoByOid(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }

}
