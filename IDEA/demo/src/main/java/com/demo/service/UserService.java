package com.demo.service;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import utils.JsonMessage;

public interface UserService {
    /**
     * 通过手机号码和密码查询用户
     * @return
     */
    public JsonMessage logincheck(String phone,String password);


    /**
     * 通过token查询用户信息
     * @param token
     * @return
     */
    public User selectUserByToken(String token);


    /**
     * 注册用户
     * @return
     */
    public JsonMessage register(String user_telephone, String user_password);


    //根据主键修改用于信息
    public int updateByPrimaryKey(User user);

}
