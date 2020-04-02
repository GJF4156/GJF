package com.demo.service;

import com.demo.pojo.Address;
import utils.JsonMessage;

import java.util.List;

public interface AddressService {
    /**
     * 新建地址
     * @return
     */
    public JsonMessage insert(Address address, String token);

    /**
     * 更新地址内容
     * @param address
     * @return
     */
    public JsonMessage update(Address address,String token);

    /**
     * 根据uid查询地址
     * @param uid
     * @return
     */
    public JsonMessage selectByUid(String uid);

    /**
     * 根据aid删除地址
     * @param aid
     * @return
     */
    public JsonMessage delete(int aid,String token);

}
