package com.ityuan.dao;
import com.ityuan.pojo.Address;
import com.ityuan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {
    /**
     * 注册用户
     * @param user
     */
    public int insertUser(User user);
    /**
     * 用户登陆
     */
    public User selectUser(@Param("phone") String phone,@Param("password") String password);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAllUser();

    /**
     * 根据用户ID查询收货地址
     * @return
     */
    public List<Address>  selectAddressByUid(int uid);

    /**
     * 重置密码
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 动态查询用户
     * @param user
     * @return
     */
    public User select(User user);
}
