package com.itguo.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itguo.model.User;
import com.itguo.util.MybatisUtils;
@Controller
@RequestMapping("/User")
public class UserController {
	
	@RequestMapping("/userLogin")
	   public String login(User user,HttpSession session,Model model) {
		   SqlSession sqlsession = MybatisUtils.getSession();
			User u = sqlsession.selectOne("com.itguo.mapper.UserMapper.selectUserByUsernameAndPassword",user);
			sqlsession.close();
			if(u!=null) {
				session.setAttribute("us", u);
				return "main";
			}else {
				model.addAttribute("msg", "µÇÂ½Ê§°Ü£¡");
				return "login";
			}
	   }
//	@RequestMapping("/userLogin")
//	public ModelAndView login(User user) {
//		ModelAndView mav=new ModelAndView();
//		SqlSession sqlsession = MybatisUtils.getSession();
//		User u = sqlsession.selectOne("com.itguo.mapper.UserMapper.selectUserByUsernameAndPassword",user);
//		sqlsession.close();
//		if(u!=null) {
//			mav.addObject("u", u);
//			mav.setViewName("main");
//		}else {
//			mav.addObject("msg", "µÇÂ½Ê§°Ü£¡");
//			mav.setViewName("login");
//		}
//		return mav;
//		
//	}
	
	@RequestMapping("/userRegist")
	   public String userRegist(User user,Model model) {
		 SqlSession sqlsession = MybatisUtils.getSession();
		 int ret=sqlsession.insert("com.itguo.mapper.UserMapper.insertUser",user);
		 sqlsession.commit();
		 sqlsession.close();
			if(ret>0) {
				return "redirect:../login";
			}else {
				model.addAttribute("msg", "×¢²áÊ§°Ü£¡");
				return "regist";
			}
	}
	
	@RequestMapping("/selectAllUser")
	public String selectAllUser(Model model) {
		SqlSession sqlsession = MybatisUtils.getSession();
		List<User> users = sqlsession.selectList("com.itguo.mapper.UserMapper.selectAllUser");
		sqlsession.close();
		if(users!=null) {
			model.addAttribute("users", users);
			return "main";
		}else {
			model.addAttribute("msg", "²éÑ¯Ê§°Ü");
			return "main";
		}
	}
	
	@RequestMapping("/DeleteUser")
	public String deleteUser(String id,Model model) {
		int uid=Integer.valueOf(id).intValue();
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret = sqlsession.delete("com.itguo.mapper.UserMapper.deleteUser",uid);
		sqlsession.commit();
		if(ret>0) {
			List<User> us = sqlsession.selectList("com.itguo.mapper.UserMapper.selectAllUser");
			sqlsession.close();
			model.addAttribute("us", us);
			return "redirect:selectAllUser";
		}else {
			sqlsession.close();
			model.addAttribute("msg", "É¾³ýÊ§°Ü");
			return "main";
		}
	}
	
	@RequestMapping("/EditUser")
	public String editUser(User user,Model model) {
		SqlSession sqlsession = MybatisUtils.getSession();
	    int ret = sqlsession.update("com.itguo.mapper.UserMapper.updateUser",user);
	    sqlsession.commit();
	    sqlsession.close();
		if(ret>0) {
			return "redirect:selectAllUser";
		}else {
			model.addAttribute("msg", "ÐÞ¸ÄÊ§°Ü");
			return "main";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
