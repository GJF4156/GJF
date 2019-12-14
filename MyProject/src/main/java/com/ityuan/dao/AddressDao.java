package com.ityuan.dao;

import com.ityuan.pojo.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {
    /**
     * 查询所有地址
     */
    public List<Address> selectAllAddress(int createuid);
    /**
     * 新建地址
     */
    public int insertAddress(Address address);
    /**
     * 删除地址
     */
    public int deleteAddress(int aid);
    /**
     *更新地址
     */
    public int updateAddress(Address address);

}
