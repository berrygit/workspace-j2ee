package com.berry.tools;

public class StringTools
{
	/**
	 * isNullOrNone 判断字符串是否为空引用或者内容为空
	 *
	 * @param string
	 * @return
	 */
	public static boolean isNullOrNone(String string)
	{
		if ((string == null) || string.equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
