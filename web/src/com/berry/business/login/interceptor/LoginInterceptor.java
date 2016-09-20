package com.berry.business.login.interceptor;

import com.berry.business.login.helper.LoginHelper;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor
{

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com
	 * .opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{

		// 取得请求相关的ActionContext实例
		ActionContext context = invocation.getInvocationContext();

		// 判断是否已登陆
		LoginHelper loginHelper = new LoginHelper();
		boolean isLogin = loginHelper.isLoginAuthenticationSuccess(context);

		if (isLogin)
		{
			return invocation.invoke();
		}
		else
		{
			return Action.LOGIN;
		}
	}
}
