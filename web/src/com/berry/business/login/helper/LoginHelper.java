package com.berry.business.login.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.berry.model.user.bean.UserBean;
import com.berry.tools.StringTools;
import com.opensymphony.xwork2.ActionContext;

public class LoginHelper
{

	public boolean isLoginAuthenticationSuccess(ActionContext context)
	{
		Map<String, Object> session = context.getSession();

		// 首先判断session，如果存在登录鉴权成功
		if ((session != null) && (session.get("userName") != null))
		{
			return true;
		}

		// 其次cookie验证，是否有记住的登录状态
		HttpServletRequest request = (HttpServletRequest) context
				.get(StrutsStatics.HTTP_REQUEST);
		Cookie[] cookies = request.getCookies();

		if (cookies == null)
		{
			return false;
		}

		for (Cookie cookie : cookies)
		{
			if ("userName".equals(cookie.getName()))
			{
				String value = cookie.getValue();

				if (!StringTools.isNullOrNone(value))
				{
					try
					{
						session.put("userName",
								URLDecoder.decode(value, "utf-8"));
					}
					catch (UnsupportedEncodingException e)
					{
						e.printStackTrace();
					}
					return true;
				}
			}
		}

		return false;
	}

	public void saveLoginState(ActionContext context, UserBean user)
	{
		// 将用户名放入session
		String userName = user.getName();
		ActionContext.getContext().getSession().put("userName", userName);

		// 添加cookie
		HttpServletResponse reponse = (HttpServletResponse) context
				.get(StrutsStatics.HTTP_RESPONSE);
		Cookie cookie;
		try
		{
			cookie = new Cookie("userName",
					URLEncoder.encode(userName, "utf-8"));
			cookie.setMaxAge(36000);
			reponse.addCookie(cookie);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}
