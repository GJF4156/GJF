package com.demo.service.serviceImpl;

import com.demo.dao.GarBageDao;
import com.demo.pojo.GarBage;
import com.demo.service.GarBageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GarBageServiceImpl implements GarBageService {
    @Autowired
    public GarBageDao garBageDao;

    @Override
    public int insert(GarBage garBage) {
        return garBageDao.insert(garBage);
    }

    @Override
    public int delete(int id) {
        return garBageDao.delete(id);
    }

    @Override
    public List<GarBage> select() {
        return garBageDao.select();
    }

    @Override
    public List<GarBage> selectByName(String name) {
        return garBageDao.selectByName(name);
    }

    @Override
    public List<GarBage> selectByType(int gtype) {
        return garBageDao.selectByType(gtype);
    }

    @Override
    public int update(GarBage garBage) {
        return garBageDao.update(garBage);
    }
}
