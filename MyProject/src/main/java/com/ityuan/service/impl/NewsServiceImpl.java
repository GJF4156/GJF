package com.ityuan.service.impl;

import com.ityuan.dao.NewsDao;
import com.ityuan.pojo.News;
import com.ityuan.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    @Override
    public List<News> findAllNews() {
        return newsDao.selectAllNews();
    }
}
