package com.ityuan.controller;

import com.ityuan.pojo.Reply;
import com.ityuan.pojo.User;
import com.ityuan.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @RequestMapping("/createReply")
    public String createReply(Reply reply,HttpServletRequest request,int fid,String content,Model model){
        User u=(User) request.getSession().getAttribute("USER");
        reply.setFid(fid);
        reply.setUid(u.getUid());
        reply.setUsername(u.getUsername());
        reply.setContent(content);
        reply.setReplyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        System.out.println(reply);
        int rows=replyService.createReply(reply);
        if (rows>0){
            return "redirect:../forum/queryForumByFid?fid="+fid;
        }else{
            model.addAttribute("fid",fid);
            return "redirect:../forum/queryForumByFid?fid="+fid;
        }
    }
    @RequestMapping("queryReply")
    public String queryReply(int fid,Model model,HttpServletRequest request){
        List<Reply> replies=replyService.queryReply(fid);
        if (replies.size()>0){
            model.addAttribute("REPLIES",replies);
            model.addAttribute("count",replies.size());
            return "reply";
        }else {
            model.addAttribute("msg","还没有回复");
            model.addAttribute("count",replies.size());
            return "reply";
        }
    }
}
