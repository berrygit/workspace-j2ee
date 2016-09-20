package algorithm;

public class AlgorithmTool {

	/**
	 * 交换整型数组中任意两个元素，first和second标示元素下标（下标从0开始计）
	 * 
	 * @param array
	 * @param first
	 * @param second
	 */
	public static void swap(int[] array, int first, int second) {

		// 参数校验
		if (array == null) {
			throw new IllegalArgumentException("array argument shouldn't be null.");
		}

		if (first < 0 || second < 0 || first >= array.length || second >= array.length) {
			throw new IllegalArgumentException(
					"first argument and second argument shouldn't be less than 0, and they shouldn't equal or be bigger than array's length.");
		}

		// 如果两个位置相同，什么都不做
		if (first == second) {
			return;
		}

		// 交换元素
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	/**
	 * 交换整型数组中任意两个元素，first和second标示元素下标（下标从0开始计）
	 * 
	 * @param array
	 * @param first
	 * @param second
	 */
	public static <E> void swap(E[] array, int first, int second) {

		// 参数校验
		if (array == null) {
			throw new IllegalArgumentException("array argument shouldn't be null.");
		}

		if (first < 0 || second < 0 || first >= array.length || second >= array.length) {
			throw new IllegalArgumentException(
					"first argument and second argument shouldn't be less than 0, and they shouldn't equal or be bigger than array's length.");
		}

		// 如果两个位置相同，什么都不做
		if (first == second) {
			return;
		}

		// 交换元素
		E temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
