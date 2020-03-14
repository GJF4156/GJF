package com.demo.dao;

import com.demo.pojo.Orders;

import java.util.List;

public interface OrdersDao {
    /**
     * 创建新订单
     *
     * @param orders
     * @return
     */
    public int insert(Orders orders);

    /**
     * 根据订单编号查询订单
     * @param oid
     * @return
     */

    public Orders selectByOid(String oid);

    /**
     * 根据用户id获取订单信息
     *
     * @param uid
     * @return
     */
    public List<Orders> selectByUid(String uid);

    /**
     * 更新订单信息
     * @param orders
     * @return
     */
    public int update(Orders orders);

}
