package com.itguo.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itguo.dao.UserBean;
import com.itguo.util.DBUtils;

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
		// TODO Auto-generated method stub
		//1.��ȡ����
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		String description = request.getParameter("description");
		//2.�ӹ�����
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		UserBean u =  new UserBean(uuid,username,password,gender,birthdate,description);
		//3.����ģ�ͣ�model)
		DBUtils dbutil = new DBUtils();
		boolean ret = dbutil.insertUser(u);
		String message="";
		if(ret==false) {
			message = "ע��ɹ�";
		}else {
			message = "ע��ʧ��";
		}
		//4.����
		request.setAttribute("msg", message);
		request.getRequestDispatcher("regist.jsp").forward(request, response);
	}
	


}
