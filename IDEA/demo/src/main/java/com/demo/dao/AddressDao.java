package com.demo.dao;

import com.demo.pojo.Address;

import java.util.List;

public interface AddressDao {

    /**
     * 新建地址
     * @return
     */
    public int insert(Address address);

    /**
     * 更新地址内容
     * @param address
     * @return
     */
    public int update(Address address);

    /**
     * 根据uid查询地址
     * @param uid
     * @return
     */
    public List<Address> selectByUid(String uid);

    /**
     * 根据aid删除地址
     * @param aid
     * @return
     */
    public int delete(int aid);
}
