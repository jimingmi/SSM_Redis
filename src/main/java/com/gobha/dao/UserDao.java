package com.gobha.dao;

import org.apache.ibatis.annotations.Param;
import com.gobha.model.User;

public interface UserDao {
	int delete(Integer user_id);

	int add(User user);

	User load(Integer user_id);

	int update(User user);

	User login(@Param("account") String account,@Param("password") String password);
}