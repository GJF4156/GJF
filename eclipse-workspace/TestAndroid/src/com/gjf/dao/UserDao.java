package com.gjf.dao;

import java.util.List;

import com.gjf.domain.User;
 
public interface UserDao {
	//�ҵ�����Ԫ��,������֤��¼��Ϣ
	public  List<User> findAll();
	//����Ԫ��,����ע��
	public void insertElement(User people);
	
}
