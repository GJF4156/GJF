package com.ityuan.controller;

import com.ityuan.pojo.User;
import com.ityuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public String insertUser(User user, Model model) {
        System.out.println(user);
        int rows = userService.insertUser(user);
        if (rows > 0) {
            return "toMemberLogin";
        } else {
            model.addAttribute("msg", "注册失败");
            return "toMemberRegist";
        }
    }

    @RequestMapping("/login")
    public String login(String phone, String password, Model model, HttpSession session) {
        User user = userService.selectUser(phone, password);
        if (user != null) {
            session.setAttribute("USER", user);
            return "redirect:../member";
        } else {
            model.addAttribute("msg", "账号或密码错误，请重新输入！");
            return "toMemberLogin";
        }
    }

    @RequestMapping("/upsateUser")
    public String updateUser(Model model, HttpServletRequest request) {
        User user=new User();
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        User u = userService.select(user);
        System.out.println(u);
        if (u!=null){
            user.setUid(u.getUid());
            user.setPassword(request.getParameter("password"));
            System.out.println("==============================\n"+user);
            int rows=userService.updateUser(user);
            if (rows>0){
                model.addAttribute("msg","找回密码成功！");
                return "toMemberLogin";
            }
            model.addAttribute("msg","找回密码失败");
            return "toBackPassword";
        }
        model.addAttribute("msg","该用户不存在，请确认后再试！");
        return "toBackPassword";
    }
}
