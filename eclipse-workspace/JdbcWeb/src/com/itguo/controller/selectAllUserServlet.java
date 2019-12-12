package com.itguo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itguo.dao.User;
import com.itguo.utils.JDBCUtil;

/**
 * Servlet implementation class selectAllUserServlet
 */
@WebServlet("/selectAllUserServlet")
public class selectAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectAllUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		JDBCUtil jdbcUtil=new JDBCUtil();
		try {
			List<User> userlist=jdbcUtil.selectAllUser();
			if (userlist!=null) {
				request.setAttribute("userlist", userlist);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("userlist", "≤È—Ø ß∞‹");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
