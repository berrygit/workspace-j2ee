package com.berry.business.register.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.berry.business.register.manager.RegisterManager;
import com.berry.model.user.bean.UserBean;
import com.berry.model.user.dao.UserDAO;
import com.berry.tools.ListTools;

@Component("registerManager")
public class RegisterManagerImpl implements RegisterManager {
	private UserDAO userDAO;

	@Override
	@Transactional
	public boolean registerUser(UserBean user) {

		List<UserBean> userList = userDAO.queryUser(user);

		if (!ListTools.isNullOrEmpty(userList)) {
			return false;
		}

		if (userDAO.addUser(user)) {
			return true;
		}

		return false;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO
	 *            the userDAO to set
	 */
	@Resource
	// 注入方式
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
