package argument;

import java.util.List;

public class ListTool {

	public static boolean isNullOrEmpty(List<? extends Object> list) {

		if (list == null || list.isEmpty()) {
			return true;
		}

		return false;
	}
}
