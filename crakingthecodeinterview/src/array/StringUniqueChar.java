package array;

public class StringUniqueChar
{
	public static boolean isCharUniqueInString(String message)
	{
		boolean[] verrifyArray = new boolean[256];

		for (int i = 0; i < message.length(); i++)
		{
			if (verrifyArray[message.charAt(i)])
			{
				return false;
			}
			else
			{
				verrifyArray[message.charAt(i)] = true;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		String testString = "abcadef";

		if (isCharUniqueInString(testString))
		{
			System.out.println("this string " + testString + " is unique!");
		}
		else
		{
			System.out.println("this string " + testString + " is not unique!");
		}
	}
}
