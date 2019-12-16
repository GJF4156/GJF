package com.ityuan.controller;

import com.ityuan.pojo.StuCard;
import com.ityuan.pojo.User;
import com.ityuan.service.StuCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/stucard")
public class StuCardController {
    @Autowired
    private StuCardService stuCardService;

    @RequestMapping("/createStuCard")
    public String createStuCard(MultipartFile cardImage, HttpServletRequest request) throws IOException {
        StuCard stuCard=new StuCard();
        //UUID解决文件名字重复的问题
        String uuid= UUID.randomUUID().toString();
        String substring=cardImage.getOriginalFilename().substring(cardImage.getOriginalFilename().lastIndexOf("."));
        //新文件名为UUID生成字符串+文件名
        String fileName=uuid+substring;
        //获取服务器所在的真实路径
        String dirPath=request.getServletContext().getRealPath("/images/");
        File fi=new File(dirPath);
        //如果路径不存在，就新建这个路径
        if (!fi.exists()){
            fi.mkdirs();
        }
        File file=new File(fi,fileName);
        cardImage.transferTo(file);
        User u = (User) request.getSession().getAttribute("USER");
        stuCard.setUid(u.getUid());
        stuCard.setRealName(request.getParameter("realName"));
        stuCard.setStuNumber(request.getParameter("stuNumber"));
        stuCard.setCardImage(fileName);
        int rows=stuCardService.createStuCard(stuCard);
        if (rows>0){
            return "account";
        }
        return "add_card";
    }
}
