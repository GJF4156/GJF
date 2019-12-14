package com.ityuan.dao;

import com.ityuan.pojo.News;

import java.util.List;

public interface NewsDao {
    /**
     * 查询所有的新闻
     * @return
     */
    public List<News> selectAllNews();


}
