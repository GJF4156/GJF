package net.tf.javaee.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.tf.javaee.model.User;
import net.tf.javaee.util.DBUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		String description = request.getParameter("description");

		// uid registdate registip
		String uid = UUID.randomUUID().toString().replace("-", "");
		Date registdate = new Date();
		String registip = request.getRemoteAddr();
		
		User u = new User(uid, username, password, gender, birthdate, description, registdate, registip);
		System.out.println(u);
		DBUtils dbutils = new DBUtils();
		boolean ret = dbutils.insertUser(u);
		
		if(ret) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "注册失败");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
		
	}

}
