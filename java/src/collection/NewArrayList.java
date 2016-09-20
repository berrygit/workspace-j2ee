package collection;

import java.util.ArrayList;
import java.util.List;

public class NewArrayList {

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();

		System.out.println(a.get(0));

		for (String c : a) {
			System.out.println(c);
		}

		int[] d = new int[10];

		for (int e : d) {
			System.out.println(e);
		}
	}

}
