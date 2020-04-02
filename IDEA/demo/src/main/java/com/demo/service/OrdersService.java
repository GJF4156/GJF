package com.demo.service;

import com.demo.pojo.Orders;
import utils.JsonMessage;

import java.util.List;

public interface OrdersService {

    /**
     * 创建新订单
     *
     * @param orders
     * @return
     */
    public int insert(Orders orders,String token);

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
    public JsonMessage update(Orders orders);
}
