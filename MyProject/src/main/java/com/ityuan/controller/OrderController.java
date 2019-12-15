package com.ityuan.controller;

import com.ityuan.pojo.Order;
import com.ityuan.pojo.User;
import com.ityuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 创建新订单
     *
     * @param order
     * @param request
     * @return
     */
    @RequestMapping("/createOrder")
    public String createOrder(Order order, HttpServletRequest request) {
        String expect_time = request.getParameter("order_date") + "  " + request.getParameter("order_time");
        order.setExpect_time(expect_time);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        order.setRelease_date(date);
        User u = (User) request.getSession().getAttribute("USER");
        order.setUid(u.getUid());
        order.setUsername(u.getUsername());
        int rows = orderService.createOrder(order);
        if (rows > 0) {
            return "redirect:../run_pool";
        } else {
            return "add_order";
        }
    }

    /**
     * 抢单
     *
     * @param order
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/confirmOrder")
    public String confirmOrder(Order order, HttpServletRequest request, Model model) {
        int receipt = ((User) request.getSession().getAttribute("USER")).getUid();
        int uid= Integer.parseInt(request.getParameter("uid"));
        int oid = Integer.parseInt(request.getParameter("oid"));
        order.setOrder_state("进行中");
        order.setReceipt(receipt);
        order.setOid(oid);
        if (uid!=((User) request.getSession().getAttribute("USER")).getUid()){
            int rows = orderService.updateOrder(order);
            if (rows > 0) {
                Order order1 = orderService.queryOrder(oid);
                System.out.println("=============================================\n"+order1);
                List<Order> orderList=orderService.queryOrderByOrderState(order);
                model.addAttribute("ORDER_LIST_BY_STATE2", orderList);
                return "run_order_2";
            } else {
                return "redirect:../run_pool";
            }
        }
        model.addAttribute("msg","您不能抢自己发布的订单");
        return "redirect:../run_pool";
    }

    /**
     * 根据receipt查询订单
     *
     * @param
     * @return
     */
    @RequestMapping("/queryOrderByReceipt")
    public String queryOrderByReceipt(HttpServletRequest request, Model model) {
        int receipt = ((User) request.getSession().getAttribute("USER")).getUid();
        List<Order> orderList = orderService.queryOrderByReceipt(receipt);
        if (orderList != null) {
            model.addAttribute("ORDER_LIST_BY_RECEIPT", orderList);
            return "run_order_2";
        } else {
            model.addAttribute("msg", "您还没抢单，赶紧去跑腿池抢单吧！");
            return "run_order_2";
        }
    }

    /**
     * 根据订单状态查询订单
     *
     * @param
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/queryOrderByOrderState")
    public String queryOrderByOrderState(Model model, HttpServletRequest request) {
        int order_state = Integer.parseInt(request.getParameter("order_state"));
        int receipt = ((User) request.getSession().getAttribute("USER")).getUid();
        List<Order> orders = null;
        Order order=new Order();
        System.out.println(order_state);
        if (order_state==1) {
            order.setOrder_state("已完成");
            order.setReceipt(receipt);
            orders = orderService.queryOrderByOrderState(order);
            System.out.println(orders);
            if (orders.size()>0) {
                model.addAttribute("ORDER_LIST_BY_STATE1", orders);
                return "run_order_1";
            } else {
                model.addAttribute("msg", "您还没有已完成订单哟");
                return "run_order_1";
            }
        } else if (order_state==2) {
            order.setOrder_state("进行中");
            order.setReceipt(receipt);
            orders = orderService.queryOrderByOrderState(order);
            System.out.println(orders);
            if (orders.size()>0) {
                model.addAttribute("ORDER_LIST_BY_STATE2", orders);
                return "run_order_2";
            } else {
                model.addAttribute("msg", "您还没有抢到订单哟");
                return "run_order_2";
            }
        } else {
            return "redirect:queryOrderByReceipt";
        }
    }

    /**
     * 取消订单
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/canserOrder")
    public String canserOrder(HttpServletRequest request,Model model){
        Order order=new Order();
        order.setOid(Integer.parseInt(request.getParameter("oid")));
        order.setReceipt(-1);
        order.setOrder_state("未处理");
        System.out.println(order);
        int rows = orderService.updateOrder(order);
        if (rows>0){
            int receipt = ((User) request.getSession().getAttribute("USER")).getUid();
            String order_state="进行中";
            Order order1=new Order();
            order1.setOrder_state(order_state);
            order1.setReceipt(receipt);
            List<Order> orders = orderService.queryOrderByOrderState(order1);
            model.addAttribute("ORDER_LIST_BY_STATE2",orders);
            return "run_order_2";
        }else {
            return "run_order_2";
        }
    }

    /**
     * 确认订单
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/confirmationOfOrder")
    public String confirmationOfOrder(HttpServletRequest request,Model model){
        int oid= Integer.parseInt(request.getParameter("oid"));
        int receipt = ((User) request.getSession().getAttribute("USER")).getUid();
        String order_state="已完成";
        Order order=new Order();
        order.setOid(oid);
        order.setReceipt(receipt);
        order.setOrder_state(order_state);
        int rows = orderService.updateOrder(order);
        if (rows>0){
            order.setOrder_state("进行中");
            List<Order> orders = orderService.queryOrderByOrderState(order);
            model.addAttribute("ORDER_LIST_BY_STATE2",orders);
            return "run_order_2";
        }
        return "run_order_2";
    }

    /**
     * 删除订单
     * @param oid
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/deleteOrder")
    public String deleteOrder(int oid,HttpServletRequest request,Model model){
        int rows = orderService.deleteOrder(oid);
        if (rows>0){
            int receipt = ((User) request.getSession().getAttribute("USER")).getUid();
            String order_state="已完成";
            Order order=new Order();
            order.setOrder_state(order_state);
            order.setReceipt(receipt);
            List<Order> orders = orderService.queryOrderByOrderState(order);
            model.addAttribute("ORDER_LIST_BY_STATE1",orders);
            return "run_order_1";
        }
        return "run_order_1";
    }
}
