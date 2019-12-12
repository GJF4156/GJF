package com.itguo.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itguo.po.User;

public class test {
	public static void main(String[] args) throws IOException {
		Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sessionFactory.openSession();
		User user=sqlSession.selectOne("com.itguo.po.UserMapper.findUserById", 1);
		List<User> userlist=sqlSession.selectList("com.itguo.po.UserMapper.all");
		System.out.println(userlist);
		sqlSession.close();
	}
	//com.itguo.po.UserMapper.all

}
