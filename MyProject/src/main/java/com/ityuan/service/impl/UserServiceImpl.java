package com.ityuan.service.impl;

import com.ityuan.dao.UserDao;
import com.ityuan.pojo.Address;
import com.ityuan.pojo.User;
import com.ityuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User selectUser(String phone, String password) {
        User user = userDao.selectUser(phone, password);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public List<Address> queryAddressByUid(int uid) {
        return userDao.selectAddressByUid(uid);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User select(User user) {
        return userDao.select(user);
    }
}
