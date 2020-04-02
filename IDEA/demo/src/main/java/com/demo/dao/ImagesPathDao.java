package com.demo.dao;

import com.demo.pojo.ImagesPath;

import java.util.List;

public interface ImagesPathDao {
    /**
     * 根据商品id查询商品对应图片
     * @param pid
     * @return
     */
    public List<ImagesPath> selectByPid(int pid);
}
