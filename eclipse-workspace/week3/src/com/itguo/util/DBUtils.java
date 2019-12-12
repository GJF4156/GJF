package com.itguo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itguo.dao.ProductBean;
import com.itguo.dao.UserBean;
import com.sun.org.apache.regexp.internal.recompile;

public class DBUtils {
	private String url = "jdbc:mysql://localhost:3306/javaee?useSSL=false&serverTimezone=UTC";
	private String username = "root";
	private String password = "gjf.33731";
	private Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	boolean i = false;

	public DBUtils() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动没找到！");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("创建连接失败！");
			e.printStackTrace();
		}
	}

	public boolean insertUser(UserBean user) {
		String sql = "INSERT INTO user VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUid());
			psmt.setString(2, user.getUsername());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getGender());
			psmt.setString(5, user.getBirthdate());
			psmt.setString(6, user.getDescription());
			boolean ret = psmt.execute();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean queryUser(UserBean userBean) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE username=? and password=?";

		psmt = conn.prepareStatement(sql);
		psmt.setString(1, userBean.getUsername());
		psmt.setString(2, userBean.getPassword());
		rs = psmt.executeQuery();
		if (rs.next()) {
			i = true;
			rs.close();
			psmt.close();
		} else {
			i = false;
			rs.close();
			psmt.close();
		}
		conn.close();
		return i;
	}

	public List<ProductBean> selectProductAll() throws SQLException {
		List<ProductBean> list = new ArrayList<ProductBean>();

		String sql = "SELECT pname,market_price,shop_price FROM product";
		psmt = conn.prepareStatement(sql);

		rs = psmt.executeQuery();
		while (rs.next()) {
			ProductBean productBean = new ProductBean();
			productBean.setPname(rs.getString("pname"));
			productBean.setMarket_price(rs.getString("market_price"));
			productBean.setShop_price(rs.getNString("shop_price"));
			list.add(productBean);
		}
		return list;
	}

	public boolean insertProduct(ProductBean productBean) {
		String sql = "INSERT INTO product VALUES(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productBean.getPname());
			psmt.setString(2, productBean.getMarket_price());
			psmt.setString(3, productBean.getShop_price());
			boolean ret = psmt.execute();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
