package heap;

import algorithm.AlgorithmTool;
import array.ArrayTool;

public class Heap {

	private int[] numbers = new int[1000];

	int size = 0;

	public Heap(int[] numbers, int size) {
		this.numbers = numbers;
		this.size = size;
	}

	public static void main(String[] args) {

		int[] numbers = {17, 63, 43, 64, 58, 54, 97, 65, 7, 2, 65, 67, 95, 34, 5, 976, 465, 35, 34, 64, 34, 643, 15,
				23, 1, 46, 32, 35, 345, 23, 9, 4, 62, 234, 77};

		new Heap(numbers, numbers.length - 1).sort();

		ArrayTool.print(numbers);
	}

	public void insert(int value) {
		numbers[++size] = value;
		shiftUp(size);
	}

	public void sort() {

		int heapsize = size;
		for (int i = heapsize / 2; i >= 1; i--) {
			shiftDown(i);
		}

		for (int i = heapsize; i >= 2; i--) {
			AlgorithmTool.swap(numbers, 1, i);
			size--;
			shiftDown(1);
		}

	}
	/**
	 * 由下向上调整堆
	 * 
	 * @param position
	 */
	private void shiftUp(int position) {
		int parentPosition = position / 2;
		while (hasParent(position) && !satisfyHeap(position, parentPosition)) {
			AlgorithmTool.swap(numbers, position, parentPosition);
			position = parentPosition;
			parentPosition = position / 2;
		}
	}

	private void shiftDown(int position) {

		while (hasLeftChild(position)) {

			int leftChild = position * 2;
			int rightChild = position * 2 + 1;

			if (hasRightChild(position)) {
				if (!satisfyHeap(rightChild, position) && numbers[rightChild] > numbers[leftChild]) {
					AlgorithmTool.swap(numbers, rightChild, position);
					position = rightChild;
					continue;
				}
			}

			if (!satisfyHeap(leftChild, position)) {
				AlgorithmTool.swap(numbers, leftChild, position);
				position = leftChild;
			}
			else {
				break;
			}
		}
	}

	private boolean hasRightChild(int position) {
		return 2 * position + 1 <= size;
	}

	private boolean hasLeftChild(int position) {
		return 2 * position <= size;
	}

	private boolean hasParent(int position) {
		return position > 1;
	}

	private boolean satisfyHeap(int position, int parentPosition) {
		return numbers[position] <= numbers[parentPosition];
	}
}
