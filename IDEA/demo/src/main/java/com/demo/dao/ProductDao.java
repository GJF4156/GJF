package com.demo.dao;

import com.demo.pojo.Product;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有商品
     * @return
     */
    public List<Product> selectAll();

    /**
     * 根据描述查询商品
     * @param description
     * @return
     */
    public List<Product> selectByDescription(String description);

    /**
     * 根据id查询商品
     * @param pid
     * @return
     */
    public Product selectById(int pid);


    /**
     * 根据销量查询商品
     * @param
     * @return
     */
    public List<Product> selectOrderBySold();
}
