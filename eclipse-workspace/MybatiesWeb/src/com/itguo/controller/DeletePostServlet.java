package com.itguo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.itguo.model.Post;
import com.itguo.model.User;
import com.itguo.util.MybatisUtils;

/**
 * Servlet implementation class DeletePostServlet
 */
@WebServlet("/DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int pid=Integer.valueOf(request.getParameter("pid"));
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret = sqlsession.delete("com.itguo.mapper.PostMapper.deletePost",pid);
		sqlsession.commit();
		if(ret>0) {
			List<Post> posts = sqlsession.selectList("com.itguo.mapper.PostMapper.selectAllPostById");
			sqlsession.close();
			request.setAttribute("posts", posts);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			sqlsession.close();
			request.setAttribute("msg", "É¾³ýÊ§°Ü1");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
