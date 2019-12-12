package com.itguo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/regist")
	public String toRegist() {
		return "regist";
	}
	
	@RequestMapping("/tomain")
	public String tomain() {
		return "main";
	}
	
	@RequestMapping("/toEdit")
	public String toEdit() {
		return "edit";
	}

}
