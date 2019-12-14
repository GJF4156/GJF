package com.ityuan.dao;

import com.ityuan.pojo.Forum;

import java.util.List;

public interface ForumDao {
    /**
     * 查询所有帖子
     * @return
     */
    public List<Forum> selectAllForum();

}
