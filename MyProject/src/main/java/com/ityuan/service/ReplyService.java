package com.ityuan.service;

import com.ityuan.pojo.Reply;

import java.util.List;

public interface ReplyService {
    /**
     * 发表评论
     * @param reply
     * @return
     */
    public int createReply(Reply reply);

    /**
     * 根据fid查询评论
     * @param fid
     * @return
     */
    public List<Reply> queryReply(int fid);
}
