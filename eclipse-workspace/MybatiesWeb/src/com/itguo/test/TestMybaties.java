package com.itguo.test;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.itguo.model.User;
import com.itguo.test.*;
import com.itguo.util.MybatisUtils;


public class TestMybaties {
	Logger logger = Logger.getLogger(TestMybaties.class);
	@Test
	public void Test() {
		SqlSession sqlsession = MybatisUtils.getSession();
//		List<User> users = sqlsession.selectList("com.itguo.mapper.UserMapper.selectUserById",1);
//		logger.info(users);
//		logger.info(users.get(0).toString());
		User user=sqlsession.selectOne("com.itguo.mapper.UserMapper.selectUserById", 1);
		logger.info(user);
		sqlsession.close();
	}
}
