package array;

public class ArrayTool {

	public static void print(int[] numbers) {

		if (numbers == null) {
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ,");
		}

		System.out.println();
		System.out.println();
	}

	public static void printWithPosition(int[] numbers) {

		if (numbers == null) {
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + "(" + i + ") ,");
		}

		System.out.println();
		System.out.println();
	}

	public static <E> void print(E[] numbers) {

		if (numbers == null) {
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ,");
		}

		System.out.println();
		System.out.println();
	}
}
