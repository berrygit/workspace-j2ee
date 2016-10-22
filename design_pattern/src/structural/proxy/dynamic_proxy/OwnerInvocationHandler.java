package structural.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler
{

	PersonBean person;

	public OwnerInvocationHandler(PersonBean person)
	{
		this.person = person;
	}

	@Override
	public Object invoke(Object person, Method method, Object[] args)
			throws Throwable
	{
		try
		{
			if (method.getName().startsWith("get"))
			{
				return method.invoke(person, args);
			}
			else if (method.getName().equals("setRatingCount"))
			{
				throw new IllegalAccessException();
			}
			else if (method.getName().startsWith("set"))
			{
				return method.invoke(person, args);
			}
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
