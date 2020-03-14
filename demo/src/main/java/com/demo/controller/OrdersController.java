package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.pojo.OrderSimple;
import com.demo.pojo.Orders;
import com.demo.pojo.User;
import com.demo.service.OrdersService;
import com.demo.service.ProductService;
import com.demo.service.UserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.JsonMessage;
import utils.TokenProccessor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value ="/insert" , method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonMessage insert(@RequestParam(value = "orderSimples",required = false) String  orderSimples, int aid, String token) {
        List<OrderSimple> list = JSON.parseArray(orderSimples, OrderSimple.class);
        User user = userService.selectUserByToken(token);
        try {
            for (int i = 0; i < list.size(); i++) {
                Orders orders = new Orders();
                String genId = TokenProccessor.genId();
                orders.setOid(genId);
                orders.setAid(aid);
                orders.setUid(user.getUsertelephone());
                orders.setPid(list.get(i).getPid());
                orders.setProductNum(list.get(i).getNum());
                orders.setAmount(productService.selectById(list.get(i).getPid()).getPrice() * list.get(i).getNum());
                orders.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                orders.setPayStatus("已支付");//测试时默认已支付
                orders.setPayTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                orders.setStatus("待发货");//测试数据
                ordersService.insert(orders, token);
            }
            return JsonMessage.success().add("success", "操作成功");
        } catch (Exception e) {
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/selectByUid")
    @ResponseBody
    public JsonMessage selectByUid(String token) {
        try {
            User user = userService.selectUserByToken(token);
            List<Orders> orders = ordersService.selectByUid(user.getUsertelephone());
            return JsonMessage.success().add("orders", orders);
        } catch (Exception e) {
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/selectByOid")
    @ResponseBody
    public JsonMessage selectByOid(String oid) {
        try {
            Orders orders = ordersService.selectByOid(oid);
            return JsonMessage.success().add("orders", orders);
        } catch (Exception e) {
            return JsonMessage.exception();
        }
    }

}
