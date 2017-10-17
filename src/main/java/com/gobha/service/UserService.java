package com.gobha.service;

import com.gobha.model.User;

public interface UserService {

	/**
	 * 登陆验证
	 * @param account
	 * @param password
	 * @return
	 */
	User login(String account,String password);

}
