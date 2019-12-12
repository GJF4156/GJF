package com.itguo.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itguo.dao.ProductBean;
import com.itguo.dao.UserBean;
import com.itguo.util.DBUtils;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/InsertProductServlet")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String pname = request.getParameter("pname");
		String mark_price = request.getParameter("mark_price");
		String shop_price = request.getParameter("shop_price");
		//2.加工数据
		
		ProductBean productBean=new ProductBean(pname,mark_price,shop_price);
		//3.调用模型（model)
		DBUtils dbutil = new DBUtils();
		boolean ret = dbutil.insertProduct(productBean);
		String message="";
		if(ret==false) {
			message = "插入成功";
		}else {
			message = "插入失败";
		}
		//4.导航
		request.setAttribute("msg", message);
		request.getRequestDispatcher("select.jsp").forward(request, response);
		
	}

}
