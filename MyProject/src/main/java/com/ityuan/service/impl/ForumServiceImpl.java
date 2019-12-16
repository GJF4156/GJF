package com.ityuan.service.impl;

import com.ityuan.dao.ForumDao;
import com.ityuan.pojo.Forum;
import com.ityuan.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumDao forumDao;
    @Override
    public List<Forum> findAllForum() {
        return forumDao.selectAllForum();
    }

    @Override
    public int createForum(Forum forum) {
        return forumDao.insertForum(forum);
    }

    @Override
    public int deleteForum(int fid) {
        return forumDao.deleteForum(fid);
    }

    @Override
    public Forum queryForumByFid(int fid) {
        return forumDao.selectForumByFid(fid);
    }
}
