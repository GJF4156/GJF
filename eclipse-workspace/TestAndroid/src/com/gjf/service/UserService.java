package com.gjf.service;

import com.gjf.domain.User;

public interface UserService {
	//�����¼
	public String checkLogin(User user);
	//ע���û�
	public String register(User user);
}
