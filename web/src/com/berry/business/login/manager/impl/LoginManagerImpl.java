package com.berry.business.login.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.berry.business.login.manager.LoginManager;
import com.berry.model.user.bean.UserBean;
import com.berry.model.user.dao.UserDAO;
import com.berry.tools.ListTools;

@Component("loginManager")
public class LoginManagerImpl implements LoginManager
{
	private UserDAO userDAO;

	@Override
	public boolean isUserValid(UserBean user)
	{
		List<UserBean> userList = userDAO.queryUser(user);

		if (!ListTools.isNullOrEmpty(userList))
		{
			for (UserBean userFromDB : userList)
			{
				if (user.getPassWord().equals(userFromDB.getPassWord()))
				{
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	/**
	 * @param userDAO
	 *            the userDAO to set
	 */
	@Resource
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
}
