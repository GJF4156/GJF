package com.itguo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itguo.dao.UserDao;
import com.itguo.entity.User;

public class DaoTest {
	
	public static void findUserByIdDaoTest() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		User user=userDao.findUserById(1);
		System.out.println(user);
		
	}
	public static void main(String[] args) {
		findUserByIdDaoTest();
	}

}
