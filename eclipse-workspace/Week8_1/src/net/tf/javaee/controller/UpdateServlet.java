package net.tf.javaee.controller;

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

import net.tf.javaee.model.User;
import net.tf.javaee.util.DBUtils;
import net.tf.javaee.util.MybatisUtils;

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
		// TODO Auto-generated method stub
		/*
		 * ���ղ��� 
		 * ��������--���ݷ�װ���Զ����� 
		 * ���÷���--�������IO 
		 * ����ҳ��--���ݷ��ؽ������߻�����·��
		 */
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		String description = request.getParameter("description");
		String uid = request.getParameter("uid");;
	    User user = new User();
	    user.setUid(uid);
	    user.setUsername(username);
	    user.setPassword(password);
	    user.setGender(gender);
	    user.setBirthdate(birthdate);
	    user.setDescription(description);
	    
		//DBUtils dbutils = new DBUtils();
		//boolean ret = dbutils.updateUser(uid, username, password, gender, birthdate, description);
		
	    SqlSession sqlsession = MybatisUtils.getSession();
	    int ret = sqlsession.update("net.tf.javaee.mapper.UserMapper.modifyUserByUid",user);
	    sqlsession.commit();
	    sqlsession.close();
		
		if(ret>0) {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "�޸�ʧ��");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
	}

}
