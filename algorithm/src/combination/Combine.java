package combination;

import java.util.HashMap;
import java.util.Map;

public class Combine {
	private static int[] size = new int[]{6, 5, 3, 2, 2, 2, 3};

	private static int[][] nums = new int[7][6];

	private static int[] positions = new int[7];

	private static int length = 7;

	private static Map<String, String> map = new HashMap<String, String>();

	private static Map<Integer, String> referMap = new HashMap<Integer, String>();

	static {
		referMap.put(0, "a");
		referMap.put(1, "b");
		referMap.put(2, "c");
		referMap.put(3, "d");
		referMap.put(4, "e");
		referMap.put(5, "f");
		referMap.put(6, "g");
	}

	public static void main(String[] args) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j] = j + 1;
			}
		}
		printInfo(0);
	}

	public static void printInfo(int position) {

		if (position == length) {

			boolean flag = false;

			for (int i = 0; i < length; i++) {
				for (int j = i + 1; j < length; j++) {
					for (int k = j + 1; k < length; k++) {
						String key = referMap.get(i) + nums[i][positions[i]] + referMap.get(j) + nums[j][positions[j]]
								+ referMap.get(k) + nums[k][positions[k]];
						String value = " ";
						if (!value.equals(map.get(key))) {
							flag = true;
							map.put(key, value);
						}
					}
				}
			}

			if (!flag) {
				return;
			}

			for (int i = 0; i < length; i++) {
				System.out.print(referMap.get(i) + nums[i][positions[i]]);
			}
			System.out.println();
			return;
		}

		for (positions[position] = 0; positions[position] < size[position]; positions[position]++) {
			printInfo(position + 1);
		}

	}
}
