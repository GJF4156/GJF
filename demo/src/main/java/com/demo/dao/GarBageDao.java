package com.demo.dao;

import com.demo.pojo.GarBage;

import java.util.List;

public interface GarBageDao {
    /**
     * 增加数据
     * @param garBage
     * @return
     */
    public int insert(GarBage garBage);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delete(int id);

    /**
     * 查询所有数据
     * @return
     */
    public List<GarBage> select();

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    public List<GarBage> selectByName(String name);

    /**
     * 根据类型查询数据
     * @param gtype
     * @return
     */
    public List<GarBage> selectByType(int gtype);

    /**
     * 更新数据
     * @param garBage
     * @return
     */
    public int update(GarBage garBage);
}
