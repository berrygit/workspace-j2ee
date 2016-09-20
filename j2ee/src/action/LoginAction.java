package action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction
{
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String passWord;

	public String execute()
	{
		// 取得请求相关的ActionContext实例
		ActionContext context = ActionContext.getContext();

		// 判断是否已经登陆
		Map<String, Object> session = context.getSession();
		if ((session != null) && (session.get("userName") != null)
				&& session.get("userName").equals(userName))
		{
			return Action.SUCCESS;
		}

		// 校验
		if ((null == userName) || "".equals(userName))
		{
			return Action.LOGIN;
		}

		// 登陆鉴权
		if (userName != null)
		{
			// 将用户名放入session
			ActionContext.getContext().getSession().put("userName", userName);

			// 添加cookie
			HttpServletResponse reponse = (HttpServletResponse) context
					.get(StrutsStatics.HTTP_RESPONSE);
			Cookie cookie;
			try
			{
				cookie = new Cookie("userName", URLEncoder.encode(userName,
						"utf-8"));
				cookie.setMaxAge(36000);
				reponse.addCookie(cookie);
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}

			return Action.SUCCESS;
		}
		else
		{
			return Action.LOGIN;
		}
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord()
	{
		return passWord;
	}

	/**
	 * @param passWord
	 *            the passWord to set
	 */
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
