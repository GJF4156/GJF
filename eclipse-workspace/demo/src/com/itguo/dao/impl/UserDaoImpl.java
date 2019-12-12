package com.itguo.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.itguo.dao.UserDao;
import com.itguo.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.itguo.entity.UserMapper.findUserById", id);
	}

	
	
}
