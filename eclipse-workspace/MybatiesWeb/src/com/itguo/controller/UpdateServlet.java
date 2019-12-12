package com.itguo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itguo.model.User;
import com.itguo.util.MybatisUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthdate = request.getParameter("birthdate");
		int id = Integer.valueOf(request.getParameter("id")).intValue();
	    User user = new User();
	    user.setId(id);
	    user.setUsername(username);
	    user.setPassword(password);
	    user.setSex(sex);
	    user.setBirthdate(birthdate);
	    SqlSession sqlsession = MybatisUtils.getSession();
	    int ret = sqlsession.update("com.itguo.mapper.UserMapper.updateUser",user);
	    sqlsession.commit();
	    sqlsession.close();
		
		if(ret>0) {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "ÐÞ¸ÄÊ§°Ü");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
	}

}
