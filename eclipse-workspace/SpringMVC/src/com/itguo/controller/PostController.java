package com.itguo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itguo.model.Post;
import com.itguo.util.MybatisUtils;

@Controller
@RequestMapping("/Post")
public class PostController {
	@RequestMapping("/report")
	public String reportPost(Post post, Model model) {
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret = sqlsession.insert("com.itguo.mapper.PostMapper.insertPost", post);
		sqlsession.commit();
		sqlsession.close();
		if (ret > 0) {
			model.addAttribute("msg", "发表成功");
			return "main";
		} else {
			model.addAttribute("msg", "发表失败");
			return "main";
		}
	}
	
	
	@RequestMapping("/SelectAllPost")
	public String selectAllPost(Model model) {
		SqlSession sqlsession = MybatisUtils.getSession();
		List<Post> posts = sqlsession.selectList("com.itguo.mapper.PostMapper.selectAllPostById");
		sqlsession.close();
		if(posts!=null) {
			model.addAttribute("posts", posts);
			return "main";
		}else {
			model.addAttribute("msg", "查询所有博客失败");
			return "main";
		}
	}
	
	@RequestMapping("/deletePost")
	public String deletePost(String pid,Model model) {
		int id=Integer.valueOf(pid).intValue();
		SqlSession sqlsession = MybatisUtils.getSession();
		int ret = sqlsession.delete("com.itguo.mapper.PostMapper.deletePost",id);
		sqlsession.commit();
		if(ret>0) {
			List<Post> posts = sqlsession.selectList("com.itguo.mapper.PostMapper.selectAllPostById");
			sqlsession.close();
			model.addAttribute("posts", posts);
			return "redirect:SelectAllPost";
		}else {
			sqlsession.close();
			model.addAttribute("msg", "删除博客失败");
			return "main";
		}
	}

}
