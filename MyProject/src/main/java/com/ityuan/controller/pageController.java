package com.ityuan.controller;

import com.ityuan.pojo.Forum;
import com.ityuan.pojo.News;
import com.ityuan.pojo.Order;
import com.ityuan.service.ForumService;
import com.ityuan.service.NewsService;
import com.ityuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller

public class pageController {
    @Autowired
    OrderService orderService;
    @Autowired
    NewsService newsService;
    @Autowired
    private ForumService forumService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<News> newsList = newsService.findAllNews();
        for (News news : newsList) {
            model.addAttribute("NEWS_DATE", new SimpleDateFormat("yyyy-MM-dd").format(news.getDate()));
        }
        model.addAttribute("NEWS", newsList);
        return "index";
    }

    @RequestMapping("/run_pool")
    public String run_pool(Model model) {
        Order order = new Order();
        order.setOrder_state("未处理");
        order.setReceipt(-1);
        List<Order> orderList = orderService.queryOrderByOrderState(order);
        if (orderList != null) {
            model.addAttribute("ORDER_LIST", orderList);
            return "run_pool";
        } else {
            model.addAttribute("msg", "还没有订单，快下单吧！");
            return "run_pool";
        }
    }

    @RequestMapping("/klist")
    public String klist(Model model) {
        List<Forum> forums = forumService.findAllForum();
        if (forums.size() > 0) {
            model.addAttribute("FORUMS", forums);
            model.addAttribute("clu",forums.size());
            return "klist";
        }
        model.addAttribute("msg", "还没有帖子，去分享自己的文章吧");
        model.addAttribute("clu",0);
        return "klist";
    }

    @RequestMapping("/member")
    public String member() {
        return "member";
    }

    @RequestMapping(value = "/toMemberLogin",method = RequestMethod.GET)
    public String toMemberLogin() {
        return "toMemberLogin";
    }

    @RequestMapping("/toMemberRegist")
    public String toMemberRegist() {
        return "toMemberRegist";
    }

    @RequestMapping("/address")
    public String address() {
        return "address";
    }

    @RequestMapping("/order")
    public String order() {
        return "order1";
    }

    @RequestMapping("/run_order")
    public String run_order() {
        return "run_order";
    }

    @RequestMapping("/run_order_1")
    public String run_order_1() {
        return "run_order_1";
    }

    @RequestMapping("/run_order_2")
    public String run_order_2() {
        return "run_order_2";
    }

    @RequestMapping("/account")
    public String account() {
        return "account";
    }

    @RequestMapping("/money")
    public String money() {
        return "money";
    }

    @RequestMapping("/add_address")
    public String add_address() {
        return "add_address";
    }

    @RequestMapping("/update_address")
    public String update_address() {
        return "update_address";
    }

    @RequestMapping("/add_order")
    public String add_order() {
        return "add_order";
    }

    @RequestMapping("/content")
    public String content() {
        return "content";
    }

    @RequestMapping("/news")
    public String news() {
        return "news";
    }

    @RequestMapping("/news_details")
    public String news_details() {
        return "news_details";
    }

    @RequestMapping("/other")
    public String other() {
        return "other";
    }

    @RequestMapping("/address_2")
    public String address_2() {
        return "address_2";
    }

    @RequestMapping("/we")
    public String we() {
        return "we";
    }

    @RequestMapping("/map")
    public String map() {
        return "map";
    }

    @RequestMapping("/toBackPassword")
    public String toBackPassword() {
        return "toBackPassword";
    }

    @RequestMapping("/userInfo")
    public String userInfo() {
        return "userInfo";
    }

    @RequestMapping("/posting")
    public String posting() {
        return "posting";
    }

    @RequestMapping("/detail")
    public String detail() {
        return "detail";
    }

    @RequestMapping("/add_card")
    public String add_card() {
        return "add_card";
    }

}
