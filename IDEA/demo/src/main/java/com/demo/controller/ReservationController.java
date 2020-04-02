package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.pojo.Reservation;
import com.demo.pojo.User;
import com.demo.service.ReservationService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.JsonMessage;
import utils.TokenProccessor;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonMessage insert(String token,@RequestParam(value = "reservation",required = false) String reservation){
        try {
            Reservation reservation1 = JSON.parseObject(reservation, Reservation.class);
            reservation1.setStatus("待接单");
            String id = TokenProccessor.genId();
            reservation1.setId(id);
            System.out.println(reservation1);
            return reservationService.insert(reservation1,token);
        }catch (Exception x){
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/select")
    @ResponseBody
    public JsonMessage select(String token){
        try {
            User user = userService.selectUserByToken(token);
            List<Reservation> reservations = reservationService.select(user.getUsertelephone());
            return JsonMessage.success().add("reservations",reservations);
        }catch (Exception e){
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public JsonMessage selectById(String id){
        try {
            return reservationService.selectById(id);
        }catch (Exception e){
            return JsonMessage.exception();
        }
    }
}
