package sort;

import algorithm.AlgorithmTool;
import array.ArrayTool;

public class QuickSort {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 4, 2, 6, 3};
		sort(numbers, 0, numbers.length - 1);

		ArrayTool.print(numbers);
	}

	public static void sort(int[] numbers, int begin, int end) {
		if (begin < end) {
			int pivot = partitionByHoare(numbers, begin, end);
			sort(numbers, begin, pivot - 1);
			sort(numbers, pivot + 1, end);
		}
	}

	/**
	 * 单向扫描的分区函数，在数组元素全相等时返回第一个
	 * 
	 * @param numbers
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int partitionByLomuto(int[] numbers, int begin, int end) {

		if (numbers == null) {
			throw new IllegalArgumentException("numbers argument sholdn't be null.");
		}

		if (begin > end) {
			throw new IllegalArgumentException("begin sholdn't be bigger than end.");
		}

		int pivot = numbers[begin];

		int pivotPosition = begin;

		for (int i = begin + 1; i <= end; i++) {

			if (numbers[i] < pivot) {
				pivotPosition++;
				AlgorithmTool.swap(numbers, i, pivotPosition);
			}
		}

		AlgorithmTool.swap(numbers, pivotPosition, begin);

		return pivotPosition;
	}

	/**
	 * 双向扫描的分区函数，当数组全相等时返回中间位置下标
	 * 
	 * @param numbers
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int partitionByHoare(int[] numbers, int begin, int end) {

		assert (numbers != null && numbers.length != 0 && begin >= 0 && end <= numbers.length && begin <= end);

		int value = numbers[begin];

		int i = begin;
		int j = end + 1;

		while (true) {

			while (++i <= end && numbers[i] < value);

			while (numbers[--j] > value);

			if (i > j) {
				break;
			}

			AlgorithmTool.swap(numbers, i, j);
		}

		AlgorithmTool.swap(numbers, begin, j);

		return j;
	}
}
