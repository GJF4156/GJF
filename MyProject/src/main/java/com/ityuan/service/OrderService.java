package com.ityuan.service;

import com.ityuan.pojo.Order;

import java.util.List;

public interface OrderService {
    /**
     * 创建新订单
     * @param order
     * @return
     */
    public int createOrder(Order order);

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> queryAllOrder();

    /**
     * 更新订单
     */
    public int updateOrder(Order order);

    /**
     * 查询单个订单
     * @param oid
     * @return
     */
    public Order queryOrder(int oid);

    /**
     * 根据receipt查询订单
     * @param receipt
     * @return
     */
    public List<Order> queryOrderByReceipt(int receipt);

    /**
     * 根据订单状态查询订单
     * @param order
     * @return
     */
    public List<Order> queryOrderByOrderState(Order order);

    /**
     * 根据oid删除订单
     * @param oid
     * @return
     */
    public int deleteOrder(int oid);

    /**
     * 查询我发布的订单
     * @param order
     * @return
     */
    public List<Order> queryMyOrder(Order order);

    /**
     * 查询我的订单（根据状态）
     * @param order
     * @return
     */
    public List<Order> queryMorder(Order order);
}
