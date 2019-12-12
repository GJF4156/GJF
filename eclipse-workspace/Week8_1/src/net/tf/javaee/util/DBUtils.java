package net.tf.javaee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import net.tf.javaee.model.User;

public class DBUtils {

	String url="jdbc:mysql://172.16.67.131:3306/javaee?useSSL=false&serverTimezone=Hongkong";
	String user="root";
	String password="toor";
	Connection conn =null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	/*
	 * 装载驱动
	 * 建立连接
	 * 
	 * 构造SQL
	 * 执行操作
	 * 处理结果
	 * 关闭资源
	 * */
	public DBUtils(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("装载驱动异常！");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接异常！");
			e.printStackTrace();
		}
	}
	
	public boolean insertUser(User u) {
		String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, u.getUid());
			psmt.setString(2, u.getUsername());
			psmt.setString(3, u.getPassword());
			psmt.setString(4, u.getGender());
			psmt.setString(5, u.getBirthdate());
			psmt.setString(6, u.getDescription());
			Long time = u.getRegistdate().getTime();
			Timestamp dt = new Timestamp(time);
			psmt.setTimestamp(7, dt);
			psmt.setString(8, u.getRegistip());
			
			boolean ret = !psmt.execute();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return false;
	}
	
	public User queryUser(String username, String password) {
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			
			rs = psmt.executeQuery();
			if(rs.next()) {	
				User u = new User();
				u.setUid(rs.getString("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setGender(rs.getString("gender"));
				u.setBirthdate(rs.getString("birthdate"));
				u.setDescription(rs.getString("description"));
				u.setRegistdate(rs.getTimestamp("registdate"));
				u.setRegistip(rs.getString("registip"));
			
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	public ArrayList<User> queryUsers() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user";
		ArrayList<User> users = new ArrayList<User>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {	
				User u = new User();
				u.setUid(rs.getString("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setGender(rs.getString("gender"));
				u.setBirthdate(rs.getString("birthdate"));
				u.setDescription(rs.getString("description"));
				u.setRegistdate(rs.getTimestamp("registdate"));
				u.setRegistip(rs.getString("registip"));
			
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}

	public boolean deleteUser(String uid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM user WHERE uid=?";
		ArrayList<User> users = new ArrayList<User>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			boolean ret = !psmt.execute();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
	}

	public void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean updateUser(String uid, String username, String password, String gender, String birthdate,
			String description) {
		String sql = "UPDATE  user SET username=?,password=?,gender=?,birthdate=? WHERE uid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			psmt.setString(3, gender);
			psmt.setString(4, birthdate);
			psmt.setString(5, uid);
			boolean ret = !psmt.execute();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return false;
	}


	
	

}
