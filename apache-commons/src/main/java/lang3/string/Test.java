package lang3.string;

import org.apache.commons.lang3.StringUtils;

public class Test {
	public static void main(String[] args) {
		String aa = null;
		String bb = "";

		System.out.println(StringUtils.isBlank(aa));
		System.out.println(StringUtils.isNotBlank(bb));
	}
}
