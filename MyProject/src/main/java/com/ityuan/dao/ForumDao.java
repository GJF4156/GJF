package com.ityuan.dao;

import com.ityuan.pojo.Forum;

import java.util.List;

public interface ForumDao {
    /**
     * 查询所有帖子
     * @return
     */
    public List<Forum> selectAllForum();

    /**
     * 插入帖子
     * @param forum
     * @return
     */
    public int insertForum(Forum forum);

    /**
     * 删除帖子
     * @param fid
     * @return
     */
    public int deleteForum(int fid);

    /**
     * 根据fid查询帖子
     * @param fid
     * @return
     */
    public Forum selectForumByFid(int fid);

}
