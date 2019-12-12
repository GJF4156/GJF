package com.test;

import java.util.List;



import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;
 
class TestDao {

	
	public static void main(String[] args) {
		UserDao dao=new UserDaoImpl();
		User user=new User();
		user.setUsername("hhh");
		user.setPassword("hhh");
		dao.insertElement(user);
		System.out.println("≤Â»Î≥…π¶");
	}
 
}
