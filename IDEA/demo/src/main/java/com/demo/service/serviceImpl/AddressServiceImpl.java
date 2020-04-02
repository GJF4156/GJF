package com.demo.service.serviceImpl;

import com.demo.dao.AddressDao;
import com.demo.dao.UserDao;
import com.demo.pojo.Address;
import com.demo.pojo.User;
import com.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.JsonMessage;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserDao userDao;

    @Override
    public JsonMessage insert(Address address, String token) {
        User user = userDao.selectUserByToken(token);
        address.setUid(user.getUsertelephone());
        System.out.println(address);
        addressDao.insert(address);
        String msg = "创建成功";
        return JsonMessage.success().add("msg", msg);
    }

    @Override
    public JsonMessage update(Address address, String token) {
        User user = userDao.selectUserByToken(token);
        address.setUid(user.getUsertelephone());
        System.out.println("更改前"+address);
        addressDao.update(address);
        return JsonMessage.success().add("msg", "修改成功");
    }

    @Override
    public JsonMessage selectByUid(String uid) {
        List<Address> addresses = addressDao.selectByUid(uid);
        return JsonMessage.success().add("addresses",addresses);
    }

        @Override
    public JsonMessage delete(int aid,String token) {
        addressDao.delete(aid);
        List<Address> addresses = addressDao.selectByUid(userDao.selectUserByToken(token).getUsertelephone());
        return JsonMessage.success().add("addresses",addresses);
    }
//    @Override
//    public JsonMessage delete(int aid, String token) {
//        addressDao.delete(aid);
//        return JsonMessage.success().add("msg", "删除成功");
//    }
}
