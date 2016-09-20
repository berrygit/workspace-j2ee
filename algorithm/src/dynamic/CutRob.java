package dynamic;

public class CutRob {
	public static int count;

	public static void main(String[] args) {
		double[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

		new CutRob().caculate(prices);
	}

	private void caculate(double[] prices) {
		for (int i = 0; i < prices.length; i++) {
			prices[i] = prices[i] / (i + 1);
			System.out.println(prices[i]);
		}

	}

	public void printCutRobSolution(int[] price, int size) {
		int[] resource = new int[size + 1];
		int[] sizes = new int[size + 1];

		extendBottomUpCutRob(price, size, resource, sizes);

		while (size > 0) {
			System.out.println(sizes[size]);
			size = size - sizes[size];
		}
	}

	private void extendBottomUpCutRob(int[] price, int size, int[] resource, int[] sizes) {
		resource[0] = 0;

		for (int i = 0; i < size; i++) {
			int cost = Integer.MIN_VALUE;

			for (int j = 0; j <= i; j++) {
				if (cost < price[j] + resource[i - j]) {
					cost = price[j] + resource[i - j];
					sizes[i + 1] = j + 1;
				}
			}

			resource[i + 1] = cost;
		}
	}

	public int bottomUpCutRob(int[] price, int size) {
		int[] resource = new int[size + 1];

		for (int i = 0; i < resource.length; i++) {
			resource[i] = 0;
		}

		for (int i = 0; i < size; i++) {
			int cost = Integer.MIN_VALUE;

			for (int j = 0; j <= i; j++) {
				cost = Math.max(cost, price[j] + resource[i - j]);
			}

			resource[i + 1] = cost;
		}

		return resource[size];
	}

	public int memoizedCutRob(int[] price, int size) {
		int[] resource = new int[size + 1];

		for (int i = 0; i < resource.length; i++) {
			resource[i] = Integer.MIN_VALUE;
		}

		return memoizedCutRobAux(price, size, resource);
	}

	private int memoizedCutRobAux(int[] price, int size, int[] resource) {
		if (resource[size] >= 0) {
			return resource[size];
		}

		int cost;

		if (size == 0) {
			cost = 0;
		}
		else {
			cost = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				cost = Math.max(cost, price[i] + memoizedCutRobAux(price, size - i - 1, resource));
			}
		}

		resource[size] = cost;

		return cost;
	}

	public int cutRob(int[] price, int size) {
		if (size == 0) {
			return 0;
		}

		int cost = Integer.MIN_VALUE;

		for (int i = 0; i < size; i++) {
			cost = Math.max(cost, price[i] + cutRob(price, size - i - 1));
		}

		return cost;
	}
}
