package com.ityuan.controller;

import com.ityuan.pojo.Address;
import com.ityuan.pojo.User;
import com.ityuan.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/selectAllAddress")
    public String selectAllAddress(int testId, Model model, HttpServletRequest request) {
        int createuid = ((User) request.getSession().getAttribute("USER")).getUid();
//        testId= Integer.parseInt(request.getParameter("testId"));
//        System.out.println(testId);
        List<Address> addressList = addressService.selectAllAddress(createuid);
        if (addressList != null) {
            model.addAttribute("ADDRESSLIST", addressList);
            if (testId == 2) {
                return "address_2";
            }
                return "address";
        } else {
            model.addAttribute("msg", "您还没添加地址！");
            if (testId == 2) {
                return "address_2";
            }
            return "address";
        }
    }

    @RequestMapping("/insertAddress")
    public String insertAddress(Address address, Model model, HttpServletRequest request) {
        String consignee = request.getParameter("consignee");
        String cphone = request.getParameter("cphone");
        String content = request.getParameter("content");
        int createuid = ((User) request.getSession().getAttribute("USER")).getUid();
        address.setConsignee(consignee);
        address.setCphone(cphone);
        address.setContent(content);
        address.setCreateuid(createuid);
        int rows = addressService.insertAddress(address);
        if (rows > 0) {
            return "redirect:selectAllAddress?testId=1";
        } else {
            model.addAttribute("msg", "新建地址失败！！");
            return "add_address";
        }
    }

    @RequestMapping("/deleteAddress")
    public String deleteAddress(int aid, Model model) {
        int rows = addressService.deleteAddress(aid);
        if (rows > 0) {
            return "redirect:selectAllAddress?testId=1";
        } else {
            model.addAttribute("msg", "删除地址失败");
            return "address";
        }
    }

    @RequestMapping("/updateAddress")
    public String updateAddress(int testId,Address address) {
        int rows = addressService.updateAddress(address);
        if (rows > 0) {
            if (testId==2){
                return "redirect:selectAllAddress?testId=2";
            }
            return "redirect:selectAllAddress?testId=1";
        } else {
            return "update_address";
        }
    }

}
