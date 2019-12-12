package net.tf.javaee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import net.tf.javaee.model.User;
import net.tf.javaee.util.DBUtils;
import net.tf.javaee.util.MybatisUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
		 * ���ղ��� 
		 * ��������--���ݷ�װ���Զ����� 
		 * ���÷���--�������IO 
		 * ����ҳ��--���ݷ��ؽ������߻�����·��
		 */
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		
		//DBUtils dbutils = new DBUtils();
		//boolean ret = dbutils.deleteUser(uid);
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret = sqlsession.delete("net.tf.javaee.mapper.UserMapper.deleteUserByUid",uid);
		sqlsession.commit();
		sqlsession.close();
		if(ret>0) {
			DBUtils dbutils2 = new DBUtils();
			ArrayList<User> us = dbutils2.queryUsers();
			request.setAttribute("users", us);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "��¼ʧ��1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
