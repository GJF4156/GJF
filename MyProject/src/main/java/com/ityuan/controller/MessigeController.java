package com.ityuan.controller;

import com.ityuan.pojo.Messige;
import com.ityuan.service.MessigeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messiges")
public class MessigeController {
    @Autowired
    MessigeService messigeService;
    @RequestMapping("/createMessige")
    public String createMessige(Messige messige, Model model){
        System.out.println("==================================================\n"+messige);
        int rows = messigeService.createMessige(messige);
         if (rows>0){
            model.addAttribute("msg","感谢您的留言");
            return "we";
        }
        model.addAttribute("msg","创建留言失败！");
        return "we";
    }
}
