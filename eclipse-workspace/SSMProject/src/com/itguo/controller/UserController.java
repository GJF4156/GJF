package com.itguo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itguo.pojo.User;
import com.itguo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("queryUserById")
	public String queryUserById(int id,Model model) {
		User user=userService.queryUserById(id);
		model.addAttribute("USER",user);
		return "index";
	}
}
