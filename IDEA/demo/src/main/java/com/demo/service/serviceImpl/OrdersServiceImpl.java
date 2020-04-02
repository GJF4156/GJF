package com.demo.service.serviceImpl;

import com.demo.dao.AddressDao;
import com.demo.dao.OrdersDao;
import com.demo.dao.UserDao;
import com.demo.pojo.Address;
import com.demo.pojo.Orders;
import com.demo.pojo.User;
import com.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.JsonMessage;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressDao addressDao;


    @Override
    public int insert(Orders orders,String token) {
        User user = userDao.selectUserByToken(token);
        orders.setUid(user.getUsertelephone());
        return ordersDao.insert(orders);
    }

    @Override
    public Orders selectByOid(String oid) {
        return ordersDao.selectByOid(oid);
    }

    @Override
    public List<Orders> selectByUid(String uid) {
        return ordersDao.selectByUid(uid);
    }

    @Override
    public JsonMessage update(Orders orders) {
        return null;
    }
}
