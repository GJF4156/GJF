package com.demo.service.serviceImpl;

import com.demo.dao.ImagesPathDao;
import com.demo.pojo.ImagesPath;
import com.demo.service.ImagesPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImagesPathServiceImpl implements ImagesPathService {
    @Autowired
    private ImagesPathDao imagesPathDao;

    @Override
    public List<ImagesPath> selectByPid(int pid) {
        return imagesPathDao.selectByPid(pid);
    }
}
