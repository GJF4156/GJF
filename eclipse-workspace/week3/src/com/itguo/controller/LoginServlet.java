package com.itguo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itguo.dao.UserBean;
import com.itguo.util.DBUtils;

/**
 * Servlet implementation class LoginServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.��ȡ����
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2.�ӹ�����
		
		//3.����ģ�ͣ�model)
		DBUtils dbutil = new DBUtils();
		boolean ret = false;
		UserBean userBean = new UserBean(username,password);
		
		try {
			ret = dbutil.queryUser(userBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String message="";
		if(ret==true) {
			message = "��¼�ɹ�";
			
		}else {
			message = "��¼ʧ��";
		}
		//4.����
		request.setAttribute("msg", message);
		request.getRequestDispatcher("select.jsp").forward(request, response);
}

}
