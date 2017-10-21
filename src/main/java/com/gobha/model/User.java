package com.gobha.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String account;
	private String password;
	private String user_name;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name == null ? null : user_name.trim();
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", account=" + account + ", password=" + password
				+ ", user_name=" + user_name + "]";
	}

}