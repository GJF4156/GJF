package com.ityuan.service.impl;

import com.ityuan.dao.AddressDao;
import com.ityuan.pojo.Address;
import com.ityuan.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> selectAllAddress(int createuid) {
        List<Address> addressList=addressDao.selectAllAddress(createuid);
        return addressList;
    }

    @Override
    public int insertAddress(Address address) {
        return addressDao.insertAddress(address);
    }


    @Override
    public int deleteAddress(int aid) {
        return addressDao.deleteAddress(aid);
    }

    @Override
    public int updateAddress(Address address) {
        return addressDao.updateAddress(address);
    }
}
