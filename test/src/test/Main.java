package test;

public class Main {

	static boolean[][] flag = new boolean[4][5];

	public static void main(String[] args) {
		char[][] map = new char[][]{{'-', '-', '#', '-', 'H'}};

		System.out.println(move(map, 0, 1));
	}

	private static boolean move(char[][] map, int i, int j) {

		if (!canMove(map, i, j)) {
			return false;
		}

		if (flag[i][j]) {
			return false;
		}

		if ('H' == map[i][j]) {
			return true;
		}

		flag[i][j] = true;

		if (move(map, i + 1, j)) {
			return true;
		}

		if (move(map, i, j - 1)) {
			return true;
		}

		if (move(map, i - 1, j)) {
			return true;
		}

		if (move(map, i, j + 1)) {
			return true;
		}

		return false;

	}

	private static boolean canMove(char[][] map, int i, int j) {

		if (i < 0 || j < 0) {
			return false;
		}

		if (i >= map.length || j >= map[0].length) {
			return false;
		}

		if ('#' == map[i][j]) {
			return false;
		}

		return true;
	}
}
