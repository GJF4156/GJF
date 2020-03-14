package com.demo.service.serviceImpl;

import com.demo.dao.ProductDao;
import com.demo.pojo.Product;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    public List<Product> selectByDescription(String description) {
        return productDao.selectByDescription(description);
    }

    @Override
    public Product selectById(int pid) {
        return productDao.selectById(pid);
    }

    @Override
    public List<Product> selectOrderBySold() {
        return productDao.selectOrderBySold();
    }
}
