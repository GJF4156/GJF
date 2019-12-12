package com.itguo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itguo.Utils.MybatisUtils;
import com.itguo.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/selectAllUser")
	public String selectAllUser(Model model) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<User> userlist = sqlSession.selectList("com.itguo.mapper.UserMapper.selectAllUser");
		sqlSession.close();
		if(userlist!=null) {
			model.addAttribute("users", userlist);
			return "index";
		}else {
			model.addAttribute("msg", "≤È—Ø ß∞‹");
			return "index";
		}
	}
}
