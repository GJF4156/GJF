package com.itguo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itguo.dao.UserDao;
import com.itguo.pojo.User;
import com.itguo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public User queryUserById(int id) {
		return (User) this.userDao.selectUserById(id);
	}
	
}
