package com.berry.business.login.action;

import com.berry.business.login.helper.LoginHelper;
import com.berry.business.login.manager.LoginManager;
import com.berry.business.login.vo.LoginInfoBean;
import com.berry.model.user.bean.UserBean;
import com.berry.tools.StringTools;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<LoginInfoBean> {

	// ModelDriven需要自己new
	private LoginInfoBean loginInfo = new LoginInfoBean();

	private LoginManager loginManager;

	public String execute() {
		// 取得请求和辅助类相关实例
		ActionContext context = ActionContext.getContext();
		LoginHelper loginHelper = new LoginHelper();

		// 登录鉴权
		if (loginHelper.isLoginAuthenticationSuccess(context)) {
			return Action.SUCCESS;
		}

		// 构建user对象
		UserBean user = buildUser();

		// 校验参数
		if (!isParameterValid(user)) {
			return "fail";
		}

		// 去数据库鉴权
		if (loginManager.isUserValid(user)) {
			loginHelper.saveLoginState(context, user);
			return Action.SUCCESS;
		}

		return "fail";
	}

	private boolean isParameterValid(UserBean user) {
		if (StringTools.isNullOrNone(user.getName())) {
			return false;
		}

		if (StringTools.isNullOrNone(user.getPassWord())) {
			return false;
		}

		return true;
	}

	private UserBean buildUser() {
		UserBean user = new UserBean();
		user.setName(loginInfo.getUserName());
		user.setPassWord(loginInfo.getPassWord());

		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public LoginInfoBean getModel() {
		return loginInfo;
	}

	/**
	 * @return the loginManager
	 */
	public LoginManager getLoginManager() {
		return loginManager;
	}

	/**
	 * @param loginManager
	 *            the loginManager to set
	 */
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

	/**
	 * @return the loginInfo
	 */
	public LoginInfoBean getLoginInfo() {
		return loginInfo;
	}

	/**
	 * @param loginInfo
	 *            the loginInfo to set
	 */
	public void setLoginInfo(LoginInfoBean loginInfo) {
		this.loginInfo = loginInfo;
	}
}
