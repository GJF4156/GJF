package com.demo.service;

import com.demo.pojo.Reservation;
import utils.JsonMessage;

import java.util.List;

public interface ReservationService {

    /**
     * 增加预约订单
     * @param reservation
     * @return
     */
    public JsonMessage insert(Reservation reservation, String token);

    /**
     * 根据用户id查询
     * @param uid
     * @return
     */
    public List<Reservation> select(String uid);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    public JsonMessage selectById(String id);

    /**
     * 根据订单id删除预约订单
     * @param id
     * @return
     */
    public JsonMessage delete(String id);

    /**
     * 修改预约订单
     * @param reservation
     * @return
     */
    public JsonMessage update(Reservation reservation);
}
