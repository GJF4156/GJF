package com.gugu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gugu.dao.RegDao;
import com.gugu.pojo.GgUser;
//ע��
/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		String userpassword=request.getParameter("userpassword");
		String email=request.getParameter("email");
		
		GgUser ggUser=new GgUser();
		ggUser.setUserName(username);
		ggUser.setUserPassword(userpassword);
		ggUser.setUserEmail(email);
		
		RegDao regDao=new RegDao();
		boolean ret=regDao.insertUser(ggUser);
		
		if (!ret) {
			request.getRequestDispatcher("fall6.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("fall7.jsp").forward(request, response);
		}
	
	}

}
