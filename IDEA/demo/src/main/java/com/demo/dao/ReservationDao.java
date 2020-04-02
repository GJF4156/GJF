package com.demo.dao;

import com.demo.pojo.Reservation;

import java.util.List;

public interface ReservationDao {

    /**
     * 增加预约订单
     * @param reservation
     * @return
     */
    public int insert(Reservation reservation);

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
    public Reservation selectById(String id);

    /**
     * 根据订单id删除预约订单
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 修改预约订单
     * @param reservation
     * @return
     */
    public int update(Reservation reservation);
}
