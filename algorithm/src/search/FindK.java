package search;

import algorithm.AlgorithmTool;
import math.RandomNum;
import sort.QuickSort;

/**
 * 时间复杂度O(n)
 * 
 * @author berry
 *
 */
public class FindK {

	public static int select(int[] numbers, int k) {

		if (numbers == null) {
			throw new IllegalArgumentException("numbers argument sholdn't be null.");
		}

		if (k < 1 || k > numbers.length) {
			throw new IllegalArgumentException("k argument sholdn't be less than 1 or bigger than numbers.length.");
		}

		// k从1开始计数，程序中自动减1
		k--;
		int low = 0;
		int high = numbers.length - 1;
		int pivot = low;

		while (low <= high) {
			AlgorithmTool.swap(numbers, low, RandomNum.generate(low, high));

			pivot = QuickSort.partitionByHoare(numbers, low, high);

			if (pivot >= k) {
				high = pivot - 1;
			}

			if (pivot <= k) {
				low = pivot + 1;
			}
		}

		return numbers[pivot];
	}

	public static void main(String[] args) {
		System.out.println(select(new int[]{13, 6, 4, 1}, 8));
	}
}
