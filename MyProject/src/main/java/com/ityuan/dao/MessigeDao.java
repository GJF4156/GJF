package com.ityuan.dao;

import com.ityuan.pojo.Messige;

public interface MessigeDao {
    /**
     * 添加留言
     * @param messige
     * @return
     */
    public int insertMessige(Messige messige);
}
