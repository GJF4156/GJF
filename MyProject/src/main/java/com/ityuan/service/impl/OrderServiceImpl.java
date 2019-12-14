package com.ityuan.service.impl;

import com.ityuan.dao.OrderDao;
import com.ityuan.pojo.Order;
import com.ityuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    //创建新订单
    @Override
    public int createOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    //查看所有订单
    @Override
    public List<Order> queryAllOrder() {
        return orderDao.selectAllOrder();
    }

    //抢单
    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    //查询单个订单信息

    @Override
    public Order queryOrder(int oid) {
        return orderDao.selectOrder(oid);
    }

    //根据receipt查询订单

    @Override
    public List<Order> queryOrderByReceipt(int receipt) {
        return orderDao.selectOrderByReceipt(receipt);
    }

    //根据订单状态查询订单

    @Override
    public List<Order> queryOrderByOrderState(Order order) {
        return orderDao.selectOrderByOrderState(order);
    }

    //根据oid删除订单
    @Override
    public int deleteOrder(int oid) {
        return orderDao.deleteOrder(oid);
    }

    //查询我发布的订单
    @Override
    public List<Order> queryMyOrder(Order order) {
        return orderDao.selectMyOrder(order);
    }

    //根据订单状态查询我的订单
    @Override
    public List<Order> queryMorder(Order order) {
        return orderDao.selectMorder(order);
    }
}
