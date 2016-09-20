package interceptor;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

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
		Map<String, Object> session = context.getSession();

		// 首先判断session
		if ((session != null) && (session.get("userName") != null))
		{
			return invocation.invoke();
		}

		// 其次cookie验证，是否有记住的登录状态
		HttpServletRequest request = (HttpServletRequest) context
				.get(StrutsStatics.HTTP_REQUEST);
		Cookie[] cookies = request.getCookies();

		if (cookies == null)
		{
			return Action.LOGIN;
		}

		for (Cookie cookie : cookies)
		{
			if ("userName".equals(cookie.getName()))
			{
				String value = cookie.getValue();

				if ((value != null) && !value.equals(""))
				{
					session.put("userName", URLDecoder.decode(value, "utf-8"));
					return invocation.invoke();
				}
			}
		}

		return Action.LOGIN;
	}
}
