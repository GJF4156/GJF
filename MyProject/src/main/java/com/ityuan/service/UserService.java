package com.ityuan.service;

import com.ityuan.pojo.Address;
import com.ityuan.pojo.User;

import java.util.List;

public interface UserService {
    public int insertUser(User user);

    public User selectUser(String phone, String password);

    public List<User> findAllUser();

    public List<Address> queryAddressByUid(int uid);

    public int updateUser(User user);

    public User select(User user);
}
