package net.tf.javaee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */

public class LoginFilter{

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURL().toString();
		System.out.println("req.getRequestURL()="+req.getRequestURL());
		if(url.indexOf("test.jsp")>0||
		   url.indexOf("LoginServlet")>0||
		   url.indexOf("RegistServlet")>0||
		   url.indexOf("style.css")>0
				) {
			chain.doFilter(request, response);
		}else {
			System.out.println("±ª¿πΩÿ¡À");
			HttpSession session = req.getSession();
			if(session.getAttribute("currentUser")!=null) {
				request.getRequestDispatcher("test.jsp").forward(request, response);
			}else {
				chain.doFilter(request, response);
			}
			
			
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
