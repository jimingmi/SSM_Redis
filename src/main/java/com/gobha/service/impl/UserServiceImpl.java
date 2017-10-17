package com.gobha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gobha.dao.UserDao;
import com.gobha.exception.LoginException;
import com.gobha.model.User;
import com.gobha.service.UserService;
import com.gobha.util.MD5Helper;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao( UserDao userDao ) {
		this.userDao = userDao;
	}

	/** 登陆验证 */
	@Override
	public User login( String account , String password ) {
		User user = userDao.login(account, MD5Helper.MD5(password, 10));
		if (user == null) {
			throw new LoginException("用户名或者密码错误，请重新登陆！");
		} else {
			return user;
		}
	}



}
