package net.tf.javaee.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import net.tf.javaee.model.User2;
import net.tf.javaee.util.MybatisUtils;

public class TestMybatisMapper {
	Logger logger = Logger.getLogger(TestMybatisMapper.class);
	@Test
	public void testMapper1N() {
		SqlSession sqlsession = MybatisUtils.getSession();
		List<User2> users = sqlsession.selectList("net.tf.javaee.mapper.UserMapper2.queryUserByUsername","zs");
		logger.info(users);
		logger.info(users.get(0).getPostlist());
		sqlsession.close();
//		[
//		 Post [postid=3, uid=null, title= 4444444444, content=null], 
//		 Post [postid=4, uid=null, title= 投影机 耗材 更多产品 下载与支持 , content=null]
//		]
	}
}
