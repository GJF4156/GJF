package com.ityuan.service;

import com.ityuan.pojo.Address;

import java.util.List;

public interface AddressService {

    public List<Address> selectAllAddress(int createuid);

    public int insertAddress(Address address);

    public int deleteAddress(int aid);

    public int updateAddress(Address address);
}
