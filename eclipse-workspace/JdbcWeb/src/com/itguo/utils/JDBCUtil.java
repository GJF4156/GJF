package com.itguo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

import com.itguo.dao.User;
import com.sun.org.apache.regexp.internal.recompile;

public class JDBCUtil {
	
	private String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
	private String username = "root";
	private String password = "gjf.33731";
	private Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	boolean i = false;
	User user=new User();
	//�������ݿ�
	public JDBCUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("����û�ҵ���");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	//ͨ��id��ѯ�����û�
	public User selectUserById(String id) throws SQLException {
		//newһ��User����
		
		//����sql���
		String sql="select * from user where id=?";
		//ִ��sql���
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if (rs.next()) {
			user.setId(rs.getString(1));
			user.setName(rs.getString(2));
			user.setPwd(rs.getString(3));
			rs.close();
			psmt.close();
			return user;
		} else {
			rs.close();
			psmt.close();
			return user;
		}
	
	}
	//��������
	public boolean insertUser(User user) {
		String sql="INSERT INTO user VALUES(?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getName());
			psmt.setString(3, user.getPwd());
			boolean ret = psmt.execute();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//�޸��û�
	public boolean UpdateUser(User user) throws SQLException {
		String sql="update user set name=? , pwd=? where id=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, user.getName());
		psmt.setString(2, user.getPwd());
		psmt.setString(3, user.getId());
		boolean ret = psmt.execute();
		return ret;
	}
	
	//ɾ���û�
	public boolean deleteUser(String id) throws SQLException {
		String sql="delete from user where id=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		boolean ret = psmt.execute();
		return ret;
	}
	//��ѯ�����û�
	public List<User> selectAllUser() throws SQLException{
		String sql="select * from user";
		List<User> userlist=new ArrayList<User>();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		while (rs.next()) {
			User user=new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPwd(rs.getString("pwd"));
			userlist.add(user);
		}
		return userlist;
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		JDBCUtil jdbcUtil=new JDBCUtil();
		User user=new User();
		user.setId("2");
		user.setName("��ѩ");
		user.setPwd("123");
		jdbcUtil.insertUser(user);
		System.out.println(jdbcUtil.selectUserById("2"));
		
	}
	
	
	
	
	

}
