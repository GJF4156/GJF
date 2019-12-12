package com.gugu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gugu.pojo.GgUser;
import com.gugu.util.DbUtil;
//注册用户
public class RegDao {
	
	private Connection conn;
	PreparedStatement psmt;
	public boolean insertUser(GgUser user) {
		DbUtil db=new DbUtil();
		
	    try {
	    	
	        String sql="insert into gg_user(user_name,user_password,user_email,user_rights) values(?,?,?,1)";
	        Connection conn=db.getCon();
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, user.getUserName());
	        psmt.setString(2, user.getUserPassword());
	        psmt.setString(3, user.getUserEmail());
	        boolean ret = psmt.execute();
			return ret;
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		GgUser ggUser=new GgUser();
		ggUser.setUserName("张三");
		ggUser.setUserPassword("123456");
		ggUser.setUserEmail("zhang@qq.com");
		RegDao regDao=new RegDao();
		regDao.insertUser(ggUser);
	}
	
	

}
