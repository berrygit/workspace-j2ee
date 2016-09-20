package com.berry.model.user.dao;

import java.util.List;

import com.berry.model.user.bean.UserBean;

public interface UserDAO
{
	List<UserBean> queryUser(UserBean user);

	boolean addUser(UserBean user);
}
