package com.itguo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itguo.dao.User;
import com.itguo.utils.JDBCUtil;

/**
 * Servlet implementation class selectUserById
 */
@WebServlet("/selectUserById")
public class selectUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public selectUserById() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		
	JDBCUtil jdbcUtil=new JDBCUtil();
	User user=null;
	
		try {
			user=jdbcUtil.selectUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user!=null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("user", "≤È—Ø ß∞‹!!!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
