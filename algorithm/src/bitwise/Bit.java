package bitwise;

public class Bit {
	public static void main(String[] args) {
		System.out.println((-1) & (-1));
	}

	private static int findOneNums(int num) {
		if (num < 0) {
			num = -num;
		}
		int count = 0;
		while (num != 0) {
			count++;
			num = num & (num - 1);
		}
		return count;
	}
}
