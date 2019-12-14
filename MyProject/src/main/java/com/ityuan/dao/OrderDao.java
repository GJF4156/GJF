package com.ityuan.dao;

import com.ityuan.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 新建订单
     * @param order
     * @return
     */
    public int insertOrder(Order order);

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> selectAllOrder();

    /**
     * 查询单个订单
     * @param oid
     * @return
     */
    public Order selectOrder(int oid);

    /**
     * 更新订单
     */
    public int updateOrder(Order order);

    /**
     * 根据receipt查询订单
     * @param receipt
     * @return
     */
    public List<Order> selectOrderByReceipt(int receipt);

    /**
     * 根据订单状态查询订单
     * @param order
     * @return
     */
    public List<Order> selectOrderByOrderState(Order order);

    /**
     * 删除订单
     * @param oid
     * @return
     */
    public int deleteOrder(int oid);

    /**
     * 查询我发布的订单
     * @param order
     * @return
     */
    public List<Order> selectMyOrder(Order order);

    /**
     * 查询我的订单（根据状态）
     * @param order
     * @return
     */
    public List<Order> selectMorder(Order order);

}
