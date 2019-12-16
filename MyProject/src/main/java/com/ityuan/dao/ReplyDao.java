package com.ityuan.dao;

import com.ityuan.pojo.Reply;

import java.util.List;

public interface ReplyDao {
    /**
     * 增加评论
     * @param reply
     * @return
     */
    public int insertReply(Reply reply);

    /**
     * 根据论坛id查询评论
     * @return
     */
    public List<Reply> selectReply(int fid);

}
