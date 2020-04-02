package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.pojo.OrderSimple;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.JsonMessage;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonMessage logincheck(String phone, String psw, HttpServletResponse response) {
        try {
            //通过服务层返回结果信息
            return userService.logincheck(phone, psw);
        } catch (Exception ex) {
            ex.printStackTrace();
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public JsonMessage register(@RequestParam(value = "phone", defaultValue = "0") String phone, @RequestParam(value = "psw", defaultValue = "0") String psw) {
        try {
            return userService.register(phone, psw);
        } catch (Exception ex) {
            ex.printStackTrace();
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/findUserInfo")
    @ResponseBody
    public JsonMessage returnUserInfo(@RequestParam(value = "token", defaultValue = "0") String token, HttpServletResponse response) {
        try {
            //通过服务层返回结果信息
            User result = this.userService.selectUserByToken(token);
            //此时查询成功，返回查询信息
            if (result != null) {
                return JsonMessage.success().add("user", result);
            } else {
                //返回失败信息
                return new JsonMessage(200, "查找失败！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return JsonMessage.exception();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonMessage updateByPrimaryKey(@RequestParam(value = "user", required = false) String user, String token) {
        try {
            //将接受到的json字符串转为User对象
            User users = JSON.parseObject(user, User.class);
            //通过token查找用户的主键
            User byToken = userService.selectUserByToken(token);
            //将主键设置到接受到的User对象中
            users.setUsertelephone(byToken.getUsertelephone());
            //更新user信息
            userService.updateByPrimaryKey(users);
            return JsonMessage.success().add("success", "修改成功");
        } catch (Exception e) {
            return JsonMessage.exception();
        }
    }
}
