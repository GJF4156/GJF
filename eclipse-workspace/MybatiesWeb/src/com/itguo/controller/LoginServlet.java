package com.itguo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itguo.model.User;
import com.itguo.util.MybatisUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		获取前端参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user1 = new User();
		user1.setUsername(username);
		user1.setPassword(password);
		HttpSession session = request.getSession();
		SqlSession sqlsession = MybatisUtils.getSession();
		User user = sqlsession.selectOne("com.itguo.mapper.UserMapper.selectUserByUsernameAndPassword",user1);
		sqlsession.close();
		if(user!=null) {
			session.setAttribute("user", user);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "登录失败1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
