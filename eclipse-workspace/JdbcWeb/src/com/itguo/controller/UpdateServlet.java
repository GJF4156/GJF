package com.itguo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itguo.dao.User;
import com.itguo.utils.JDBCUtil;

/**
 * Servlet implementation class UpdateServlet
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPwd(pwd);
		JDBCUtil jdbcUtil=new JDBCUtil();
		boolean ret;
		try {
			ret = jdbcUtil.UpdateUser(user);
			if (!ret) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "ÐÞ¸ÄÊ§°Ü");
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
