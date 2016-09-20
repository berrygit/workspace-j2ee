package com.berry.business.login.manager;

import com.berry.model.user.bean.UserBean;

public interface LoginManager
{

	boolean isUserValid(UserBean user);
}
