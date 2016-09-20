package com.berry.tools;

import java.util.List;

public class ListTools
{
	public static boolean isNullOrEmpty(List<? extends Object> list)
	{
		if ((list == null) || list.isEmpty())
		{
			return true;
		}

		return false;
	}
}
