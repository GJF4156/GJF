package com.ityuan.service;

import com.ityuan.pojo.Forum;

import java.util.List;

public interface ForumService {
    /**
     * 查寻所有的帖子
     * @return
     */
    public List<Forum> findAllForum();

    /**
     * 发表帖子
     * @param forum
     * @return
     */
    public int createForum(Forum forum);

    /**
     * 删除帖子
     * @param fid
     * @return
     */
    public int deleteForum(int fid);
}
