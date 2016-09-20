package math;

/**
 * 分治思想的应用，简单的一分为二，却具有强大的力量，分治同时判断指数位上是否有数字，以此作为乘方的依据。
 * 
 * @author berry
 *
 */
public class Power {

	private static final int MASK = 0x01;

	/**
	 * exponent can't be less than 0.
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static int compute(int base, int exponent) {

		if (exponent < 0) {
			throw new IllegalArgumentException("exponent can't be less than 0");
		}

		if (base == 0) {
			return 0;
		}

		int answer = 1;

		while (exponent != 0) {

			if ((exponent & MASK) == 1) {
				answer *= base;
			}
			base = base * base;
			exponent >>= 1;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(powerW(2, 9));
	}

	public static int powerW(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		}

		if (exponent == 1) {
			return base;
		}

		int result = powerW(base, exponent >> 1);
		result *= result;
		if ((exponent & 1) == 1) {
			result *= base;
		}
		return result;
	}
}
