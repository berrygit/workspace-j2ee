package print;

public class Print {

	private static char[][] info = new char[][]{{' '}, {' '}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'},
			{'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
	private static int[] count = new int[]{1, 1, 3, 3, 3, 3, 3, 4, 3, 4};

	public static void main(String[] args) {
		int[] number = new int[]{1, 5, 1, 6, 5, 4, 6, 0, 1, 2, 7};
		int[] answer = new int[11];

		print(number, answer, 0, 11);

	}
	public static void print(int[] number, int[] answer, int index, int n) {
		if (index == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(info[number[i]][answer[i]]);
			}

			System.out.println();
			return;
		}
		for (answer[index] = 0; answer[index] < count[number[index]]; answer[index]++) {
			print(number, answer, index + 1, n);
		}
	}
}
