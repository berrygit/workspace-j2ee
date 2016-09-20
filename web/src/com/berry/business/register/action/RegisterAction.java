package com.berry.business.register.action;

import com.berry.business.register.manager.RegisterManager;
import com.berry.business.register.vo.RegisterInfo;
import com.berry.model.user.bean.UserBean;
import com.berry.tools.StringTools;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction implements ModelDriven<RegisterInfo>
{
	private RegisterInfo registerInfo = new RegisterInfo();
	private RegisterManager registerManager;

	public String execute()
	{
		// 校验参数
		if (!isParamValid(registerInfo))
		{
			return "fail";
		}

		UserBean user = buildUser();
		if (registerManager.registerUser(user))
		{
			return Action.SUCCESS;
		}

		return "fail";
	}

	private boolean isParamValid(RegisterInfo registerInfo)
	{
		// 校验用户名
		if (StringTools.isNullOrNone(registerInfo.getUserName()))
		{
			return false;
		}

		// 校验密码
		String passWord = registerInfo.getPassWord();
		if (!StringTools.isNullOrNone(passWord))
		{
			if (passWord.equals(registerInfo.getConfirmPassWord()))
			{
				return true;
			}
		}

		return false;
	}

	private UserBean buildUser()
	{
		UserBean user = new UserBean();
		user.setName(registerInfo.getUserName());
		user.setPassWord(registerInfo.getPassWord());

		return user;
	}

	/**
	 * @return the registerManager
	 */
	public RegisterManager getRegisterManager()
	{
		return registerManager;
	}

	/**
	 * @param registerManager
	 *            the registerManager to set
	 */
	public void setRegisterManager(RegisterManager registerManager)
	{
		this.registerManager = registerManager;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public RegisterInfo getModel()
	{
		// TODO Auto-generated method stub
		return registerInfo;
	}

}
