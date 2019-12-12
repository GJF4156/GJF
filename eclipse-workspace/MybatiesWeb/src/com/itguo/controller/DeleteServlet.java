package com.itguo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import com.itguo.model.User;
import com.itguo.util.MybatisUtils;

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
		 * 接收参数 
		 * 处理数据--数据封装，自动生成 
		 * 调用方法--完成数据IO 
		 * 导航页面--根据返回结果合理策划导航路径
		 */
		request.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("id")).intValue();
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret = sqlsession.delete("com.itguo.mapper.UserMapper.deleteUser",id);
		sqlsession.commit();
		if(ret>0) {
			List<User> us = sqlsession.selectList("com.itguo.mapper.UserMapper.selectAllUser");
			sqlsession.close();
			request.setAttribute("users", us);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			sqlsession.close();
			request.setAttribute("msg", "删除失败1");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
	}

}
