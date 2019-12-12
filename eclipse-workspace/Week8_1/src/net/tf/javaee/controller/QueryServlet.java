package net.tf.javaee.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import net.tf.javaee.model.User;
import net.tf.javaee.util.DBUtils;
import net.tf.javaee.util.MybatisUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(QueryServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 接收参数 
		 * 处理数据--数据封装，自动生成 
		 * 调用方法--完成数据IO 
		 * 导航页面--根据返回结果合理策划导航路径
		 */
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("uname");
		//System.out.println(username);
		
//		DBUtils dbutils = new DBUtils();
//		ArrayList<User> us = dbutils.queryUsers();
		
		SqlSession sqlsession = MybatisUtils.getSession();
		List<User> users = sqlsession.selectList("net.tf.javaee.mapper.UserMapper.queryAllUsers");
		logger.info(users);
		sqlsession.close();
		
		if(users!=null) {
			request.setAttribute("users", users);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "登录失败1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
