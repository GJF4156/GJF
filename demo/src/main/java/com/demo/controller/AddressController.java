package com.demo.controller;

import com.demo.pojo.Address;
import com.demo.pojo.User;
import com.demo.service.AddressService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.JsonMessage;

import java.util.Map;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;


    @RequestMapping("/insert")
    @ResponseBody
    public JsonMessage insert(String receiver,String phone,String address, String token){
        Address address1=new Address();
        address1.setReceiver(receiver);
        address1.setPhone(phone);
        address1.setAddress(address);
        try {
            return addressService.insert(address1,token);
        }catch (Exception ex){
            ex.printStackTrace();
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonMessage delete(int aid,String token){
        try {
            return addressService.delete(aid,token);
        }catch (Exception ex){
            ex.printStackTrace();
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonMessage update(Address address,String token){
        try {
            return addressService.update(address,token);
        }catch (Exception ex){
            ex.printStackTrace();
            return JsonMessage.exception();
        }
    }

    @RequestMapping("/select")
    @ResponseBody
    public JsonMessage select(String token){
        try {
            User user = userService.selectUserByToken(token);
            return addressService.selectByUid(user.getUsertelephone());
        }catch (Exception ex){
            ex.printStackTrace();
            return JsonMessage.exception();
        }
    }
}
