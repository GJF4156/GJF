package com.ityuan.controller;

import com.ityuan.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求URL
//        String url=request.getRequestURI();
//        //URL除了toMemberLogin.jsp是可以公开访问的，其他的URL都进行拦截
////        if (url.indexOf("/toMemberLogin")>=0 ){
////            return true;
////        }
//        //获取session
//        HttpSession session=request.getSession();
//        User user= (User) session.getAttribute("USER");
//        //判断session是否有用户数据，如果有，则返回true,继续向下执行
//        if (user!=null){
//            return true;
//        }
//        //不符合条件的给出提示信息，并转发到登陆界面
//        request.setAttribute("msg","您还没有登陆，请先登录！");
//        request.getRequestDispatcher("/WEB-INF/toMemberLogin.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
