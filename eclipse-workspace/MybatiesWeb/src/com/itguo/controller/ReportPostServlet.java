package com.itguo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.itguo.model.Post;
import com.itguo.model.User;
import com.itguo.util.MybatisUtils;

/**
 * Servlet implementation class ReportPostServlet
 */
@WebServlet("/ReportPostServlet")
public class ReportPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		Post post=new Post();
		post.setUsername(username);
		post.setTitle(title);
		post.setContext(context);
		HttpSession session = request.getSession();
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret=sqlsession.insert("com.itguo.mapper.PostMapper.insertPost",post);
		sqlsession.commit();
		sqlsession.close();
		if(ret>0) {
			request.setAttribute("msg", "发表成功");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "发表失败");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	
	
	
	
	
	}

}
