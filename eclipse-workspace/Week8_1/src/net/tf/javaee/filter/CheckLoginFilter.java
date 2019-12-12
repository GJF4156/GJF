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
 * Servlet Filter implementation class CheckLoginFilter
 */
@WebFilter("/*")
public class CheckLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLoginFilter() {
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
		String url = req.getRequestURI();
		System.out.println(url);
		if(url.indexOf("index.html")>0||
			url.indexOf("regist.jsp")>0||
			url.indexOf("login.jsp")>0||
			url.indexOf("RegistSevlet")>0||
			url.indexOf("LoginServlet")>0) {
			chain.doFilter(request, response);
		}else {
			HttpSession session = req.getSession();
			if(session.getAttribute("currentUser")!=null) {
				chain.doFilter(request, response);
			}else {
				req.getRequestDispatcher("login.jsp").forward(req, response);
			}
		}
	
		//System.out.println("ƒ„±ª¿πΩÿ¡À");
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
