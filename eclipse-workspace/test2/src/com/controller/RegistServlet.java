package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.UserDaoImpl;
import com.domain.User;


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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");//�����������(post)
		response.setCharacterEncoding("UTF-8");//�����Ӧ����,����Ҫ���ַ�����������ֽ��������Ҫ�ٴα��룩
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sign=request.getParameter("sign");
		PrintWriter out=response.getWriter();
		//�Ѵ��������ݷ�װ��javabean��
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		  
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		userDaoImpl.insertElement(user);
		
	}

}
