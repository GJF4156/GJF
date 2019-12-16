package com.ityuan.service.impl;

import com.ityuan.dao.ReplyDao;
import com.ityuan.pojo.Reply;
import com.ityuan.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;
    //发表评论
    @Override
    public int createReply(Reply reply) {
        return replyDao.insertReply(reply);
    }
    //根据fid查询评论
    @Override
    public List<Reply> queryReply(int fid) {
        return replyDao.selectReply(fid);
    }
}
