package action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction
{

	public String execute()
	{

		// 取得请求相关的ActionContext实例
		ActionContext context = ActionContext.getContext();

		// 删除session
		Map<String, Object> session = context.getSession();
		session.remove("userName");

		// 清空cookie
		HttpServletResponse reponse = (HttpServletResponse) context
				.get(StrutsStatics.HTTP_RESPONSE);
		Cookie cookie = new Cookie("userName", "");
		reponse.addCookie(cookie);

		return Action.SUCCESS;
	}
}
