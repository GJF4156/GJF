package com.ityuan.service.impl;

import com.ityuan.dao.MessigeDao;
import com.ityuan.pojo.Messige;
import com.ityuan.service.MessigeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessigeServiceImpl implements MessigeService {
    @Autowired
    MessigeDao messigeDao;
    @Override
    public int createMessige(Messige messige) {
        return messigeDao.insertMessige(messige);
    }
}
