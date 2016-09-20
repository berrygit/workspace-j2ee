package sort;

import array.ArrayTool;

public class MergeSort {

	public static void main(String[] args) {

		int[] numbers = {17, 63, 43, 64, 58, 54, 97, 65, 7, 2, 67, 95, 34, 5, 976, 465, 35, 643, 15, 1, 46, 32, 345,
				23, 9, 4, 62, 234, 77};
		sort(numbers, 0, numbers.length - 1);

		ArrayTool.print(numbers);

	}

	/**
	 * 
	 * 分治，缺点是用了过多的内存O(nlogn)
	 * 
	 * @param numbers
	 * @param begin
	 * @param end
	 */
	private static void sort(int[] numbers, int begin, int end) {

		if (begin < end) {
			int mid = (begin + end) / 2;
			sort(numbers, begin, mid);
			sort(numbers, mid + 1, end);
			merge(numbers, begin, mid, end);
		}
	}

	private static void merge(int[] numbers, int begin, int mid, int end) {

		int n1 = mid - begin + 1;
		int n2 = end - mid;

		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];

		for (int i = 0; i < left.length - 1; i++) {
			left[i] = numbers[begin + i];
		}

		for (int i = 0; i < right.length - 1; i++) {
			right[i] = numbers[mid + 1 + i];
		}

		// 哨兵
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;

		int l_count = 0;
		int r_count = 0;

		for (int i = begin; i <= end; i++) {

			// =号确保排序的稳定性
			if (left[l_count] <= right[r_count]) {
				numbers[i] = left[l_count];
				l_count++;
			}
			else {
				numbers[i] = right[r_count];
				r_count++;
			}
		}
	}
}