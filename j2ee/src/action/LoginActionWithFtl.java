package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginActionWithFtl
{

	private String name1 = "AAAAA";

	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("name2", "BBBBB");
		return Action.SUCCESS;
	}

	public String getName1()
	{
		return name1;
	}

	public void setName1(String name1)
	{
		this.name1 = name1;
	}
}
