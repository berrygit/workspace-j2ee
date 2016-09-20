package tools;

public class StringTools
{
	/**
	 * isNullOrNone 判断字符串是否为空引用或者内容为空
	 *
	 * @param message
	 * @return
	 */
	public static boolean isNullOrNone(String message)
	{
		if ((message == null) || message.equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
