package com.ityuan.service.impl;

import com.ityuan.dao.StuCardDao;
import com.ityuan.pojo.StuCard;
import com.ityuan.service.StuCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StuCardServiceImpl implements StuCardService {
    @Autowired
    private StuCardDao stuCardDao;
    @Override
    public int createStuCard(StuCard stuCard) {
        return stuCardDao.insertStuCard(stuCard);
    }
}
