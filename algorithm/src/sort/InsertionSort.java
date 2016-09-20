package sort;

import array.ArrayTool;

public class InsertionSort {

	public static void main(String[] args) {

		int[] numbers = {17, 63, 43, 64, 58, 54, 97, 65, 7, 2, 65, 67, 95, 34, 5, 976, 465, 35, 34, 64, 34, 643, 15,
				23, 1, 46, 32, 35, 345, 23, 9, 4, 62, 234, 77};
		sort(numbers);

		ArrayTool.print(numbers);
	}

	/**
	 * 插入排序由于要比较所有情况，所以时间复杂度高O(n)，但是由于有很好的局部性可以很好的利用CPU高速缓存，
	 * 因而在处理小数据量的排序时有很好的表现。
	 * 
	 * @param numbers
	 */
	private static void sort(int[] numbers) {

		for (int i = 1; i < numbers.length; i++) {
			int key = numbers[i];
			int j = i - 1;

			while ((j >= 0) && (numbers[j] > key)) {
				numbers[j + 1] = numbers[j];
				j = j - 1;
			}

			numbers[j + 1] = key;
		}
	}

}
