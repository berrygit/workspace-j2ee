package sort;

import algorithm.AlgorithmTool;

public class Heap_sort {
	static int[] numbers = {17, 63, 43, 64, 58, 54, 97, 65, 7, 2, 65, 67, 95, 34, 5, 976, 465, 35, 34, 64, 34, 643, 15,
			23, 1, 46, 32, 35, 345, 23, 9, 4, 62, 234, 77};

	static int heap_size = numbers.length;

	public static void main(String[] args) {
		sort(numbers);

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " , ");
		}
	}

	private static void sort(int[] numbers) {
		buildMaxHeap(numbers);

		for (int i = numbers.length - 1; i > 0; i--) {
			AlgorithmTool.swap(numbers, 0, i);
			heap_size = heap_size - 1;
			maxHeapify(numbers, 0);
		}
	}

	private static void buildMaxHeap(int[] numbers) {
		for (int i = (numbers.length - 1) / 2; i >= 0; i--) {
			maxHeapify(numbers, i);
		}
	}

	private static void maxHeapify(int[] numbers, int i) {
		int left = getLeftChildPosition(i);
		int right = getRightChildPosition(i);

		int largest = i;

		if (left < heap_size && numbers[i] < numbers[left]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right < heap_size && numbers[right] > numbers[largest]) {
			largest = right;
		}

		if (largest != i) {
			AlgorithmTool.swap(numbers, i, largest);
			maxHeapify(numbers, largest);
		}
	}

	private static int getRightChildPosition(int i) {
		return 2 * i + 1;
	}

	private static int getLeftChildPosition(int i) {
		return 2 * i;
	}
}
