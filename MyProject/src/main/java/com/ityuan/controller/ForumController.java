package com.ityuan.controller;

import com.ityuan.pojo.Forum;
import com.ityuan.pojo.Reply;
import com.ityuan.pojo.User;
import com.ityuan.service.ForumService;
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
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;
    @Autowired
    private ReplyService replyService;

    @RequestMapping("/createForum")
    public String createForum(Forum forum, Model model, HttpServletRequest request){
        User u=(User) request.getSession().getAttribute("USER");
        int publishUid=u.getUid();
        String publishUser=u.getUsername();
        String content=request.getParameter("content");
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        forum.setFid(0);
        forum.setPublishUid(publishUid);
        forum.setPublishUser(publishUser);
        forum.setContent(content);
        forum.setDate(date);
        int rows=forumService.createForum(forum);
        if (rows>0){
            return "redirect:../klist";
        }
        model.addAttribute("msg","发布失败，请重试");
        return "posting";
    }

    /**
     * 根据fid查询帖子
     * @return
     */
    @RequestMapping("/queryForumByFid")
    public String queryForumByFid(int fid,Model model){
        Forum forum=forumService.queryForumByFid(fid);
        if (forum!=null){
            List<Reply> replies=replyService.queryReply(fid);
            model.addAttribute("count",replies.size());
            model.addAttribute("FORUM",forum);
            return "detail";
        }
        return "detail";
    }
}
