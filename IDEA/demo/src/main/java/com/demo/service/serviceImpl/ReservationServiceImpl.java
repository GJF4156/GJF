package com.demo.service.serviceImpl;

import com.demo.dao.ReservationDao;
import com.demo.dao.UserDao;
import com.demo.pojo.Reservation;
import com.demo.pojo.User;
import com.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.JsonMessage;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private UserDao userDao;
    @Override
    public JsonMessage insert(Reservation reservation, String token) {
        User user = userDao.selectUserByToken(token);
        reservation.setUid(user.getUsertelephone());
        reservationDao.insert(reservation);
        return JsonMessage.success().add("success","预约成功");
    }

    @Override
    public List<Reservation> select(String uid) {
        return reservationDao.select(uid);
    }

    @Override
    public JsonMessage selectById(String id) {
        return JsonMessage.success().add("reservation",reservationDao.selectById(id));
    }

    @Override
    public JsonMessage delete(String id) {
        reservationDao.delete(id);
        return JsonMessage.success().add("success","删除成功");
    }

    @Override
    public JsonMessage update(Reservation reservation) {
        reservationDao.update(reservation);
        return JsonMessage.success().add("success","更新成功");
    }
}
