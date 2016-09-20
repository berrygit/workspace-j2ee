package math;

public class GCD {

	/**
	 * 辗转相减
	 * 
	 * @param numA
	 * @param numB
	 * @return
	 */
	public static int getBySub(int numA, int numB) {

		while (numA != numB) {
			if (numA > numB) {
				numA -= numB;
			}
			else {
				numB -= numA;
			}
		}

		return numA;
	}

	/**
	 * 辗转相余
	 * 
	 * @param numA
	 * @param numB
	 * @return
	 */
	public static int getByMod(int numA, int numB) {

		if (numB > numA) {
			getByMod(numB, numA);
		}

		if (numB == 0) {
			return numA;
		}

		return getByMod(numB, numA % numB);
	}

	public static void main(String[] args) {
		System.out.println(getByMod(4, 6));
	}
}
