package com.demo.service.serviceImpl;

import com.demo.dao.UserDao;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.JsonMessage;
import utils.OtherStatus;
import utils.TokenProccessor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public JsonMessage logincheck(String phone, String password) {
        //判断输入格式

        //对密码解密

        //查询数据库
        System.out.println(phone+"    "+password);
        User user = userDao.selectUserByTelephoneAndPassword(phone, password);
        System.out.println(user.getUsertelephone());
        if (user == null) {
            return new JsonMessage(200, "登录失败，请核账号信息！");
        }

        //获取到token
        String tokenPattern = TokenProccessor.GetTokenPattern();

        //对用户对象设置
        user.setToken(tokenPattern);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(d);
        user.setUserlastloginDate(s);
        System.out.println(user);
        //将对象保存到数据库
        userDao.updateByPrimaryKey(user);
        return JsonMessage.success().add("token", tokenPattern);
    }

    @Override
    public User selectUserByToken(String token) {
        return userDao.selectUserByToken(token);
    }

    @Override
    public JsonMessage register(String user_telephone, String user_password) {
        //判断输入格式是否正确

        //判断用户是否存在
        if (userDao.selectUserByPhone(user_telephone) != null) {
            return new JsonMessage(200, "该用户已经存在！");
        }
        //对密码进行加密

        //创建注册对象
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(d);
        User user = new User(1, null, null, null, null, null, user_telephone, null, null, user_password, s, s,  OtherStatus.logouttoken);
        //将新用户添加进数据库
        userDao.insertUser(user);

        return JsonMessage.success().add("phone",user_telephone);
    }


    @Override
    public int updateByPrimaryKey(User user) {
        return userDao.updateByPrimaryKey(user);
    }
}
