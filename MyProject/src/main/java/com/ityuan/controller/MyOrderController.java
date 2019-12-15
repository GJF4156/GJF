package com.ityuan.controller;

import com.ityuan.pojo.Order;
import com.ityuan.pojo.User;
import com.ityuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/mOrder")
public class MyOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 根据id查询对应的订单（0：未处理 1：已处理 2：进行中）
     *
     * @param order
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/queryOrder")
    public String queryOrder(Order order, int id, HttpServletRequest request, Model model) {
        User u = (User) request.getSession().getAttribute("USER");
        order.setUid(u.getUid());
        switch (id) {
            case 0:
                order.setOrder_state("未处理");
                order.setReceipt(-1);
                List<Order> orders = orderService.queryMyOrder(order);
                if (orders.size() > 0) {
                    model.addAttribute("ORDERS", orders);
                    return "order1";
                }
                model.addAttribute("msg", "暂无未处理订单");
                return "order1";
            case 1:
                order.setOrder_state("已完成");
                List<Order> orders1 = orderService.queryMorder(order);
                if (orders1.size() > 0) {
                    model.addAttribute("ORDERS", orders1);
                    return "order1";
                }
                model.addAttribute("msg", "暂无已完成订单");
                return "order1";
            case 2:
                order.setOrder_state("进行中");
                List<Order> orders2 = orderService.queryMorder(order);
                if (orders2.size() > 0) {
                    model.addAttribute("ORDERS", orders2);
                    return "order1";
                }
                model.addAttribute("msg", "暂无进行中订单");
                return "order1";
            default:
                model.addAttribute("msg", "您还没有任何订单");
                return "order1";
        }
    }

    @RequestMapping("/deleteMorder")
    public String deleteMorder(int oid,HttpServletRequest request,Model model){
        User u = (User) request.getSession().getAttribute("USER");
        int rows = orderService.deleteOrder(oid);
        if (rows>0){
            return "redirect:queryOrder?id=0";
        }
        return "redirect:queryOrder?id=0";
    }



}
