package com.gugu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gugu.util.DbUtil;
//管理员界面  微语删除   微语评论删除
public class WisDelDao {
	public boolean del(int id) {
		DbUtil db=new DbUtil();
		try {
            String sql="DELETE FROM gg_note WHERE note_id="+id;
            Connection conn=db.getCon();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.executeUpdate();
            DbUtil.getClose(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }	
		return true;
	}
	
	public boolean delCom(int id) {
		DbUtil db=new DbUtil();
		try {
            String sql="DELETE FROM gg_note_com WHERE note_com_id="+id;
            Connection conn=db.getCon();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.executeUpdate();
            DbUtil.getClose(conn);            
        } catch (Exception e) {
            e.printStackTrace();
        }		
		return true;
	}
}
