package com.itguo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.itguo.model.Reply;
import com.itguo.model.User;
import com.itguo.util.MybatisUtils;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String reply=request.getParameter("reply");
		String username=request.getParameter("username");
		String title=request.getParameter("title");
		String context=request.getParameter("context");
		Reply reply2=new Reply();
		reply2.setTitle(title);
		reply2.setContext(context);
		reply2.setUsername(username);
		reply2.setReplyContext(reply);
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret = sqlsession.insert("com.itguo.mapper.ReplyMapper.insertReply",reply2);
		if(ret>0) {
			List<Reply> replies=sqlsession.selectList("com.itguo.mapper.ReplyMapper.selectAllReply");
			sqlsession.close();
			request.setAttribute("replies", replies);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			sqlsession.close();
			request.setAttribute("msg", "∆¿¬€ ß∞‹1");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
	}

}
