package com.demo.dao;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    /**
     * 通过手机号码和密码查询用户
     * @return
     */
    public User selectUserByTelephoneAndPassword(@Param("usertelephone") String user_telephone,@Param("userpassword") String user_password);

    public User selectUserByPhone(@Param("usertelephone") String user_telephone);


    /**
     * 通过token查询用户信息
     * @param token
     * @return
     */
    public User selectUserByToken(String token);


    /**
     * 注册用户
     * @param user
     * @return
     */
    public int insertUser(User user);


    //根据主键修改用于信息
    public int updateByPrimaryKey(User user);
}
