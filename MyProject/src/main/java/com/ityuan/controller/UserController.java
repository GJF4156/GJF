package com.ityuan.controller;

import com.ityuan.pojo.User;
import com.ityuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @param model
     * @return
     */
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

    /**
     * 登陆
     * @param phone
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String phone, String password, Model model, HttpSession session) {
        User user = userService.selectUser(phone, password);
        if (user != null) {
            session.setAttribute("USER", user);
            return "member";
        } else {
            model.addAttribute("msg", "账号或密码错误，请重新输入！");
            return "toMemberLogin";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清楚session
        session.invalidate();
        //重定向到登陆界面
        return "redirect:../toMemberLogin";
    }

    /**
     * 找回密码
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/toBackPassword")
    public String toBackPassword(Model model, HttpServletRequest request) {
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

    /**
     * 修改用户信息
     * @param user
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(User user,Model model,HttpServletRequest request,HttpSession session){
        user.setUid(((User) request.getSession().getAttribute("USER")).getUid());
        int rows=userService.updateUser(user);
        if (rows>0){
            session.setAttribute("USER", user);
            model.addAttribute("msg","修改信息成功");
            return "account";
        }
        model.addAttribute("msg","修改信息失败！");
        return "userInfo";
    }
}
