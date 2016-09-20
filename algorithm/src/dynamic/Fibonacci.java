package dynamic;
public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci numbers = new Fibonacci();
		int n = 40;

		int[] fibonaccis = new int[n + 1];

		for (int i = 0; i < fibonaccis.length; i++) {
			fibonaccis[i] = Integer.MIN_VALUE;
		}

		System.out.println(numbers.dynamicGetFibonacci(n, fibonaccis));

		System.out.println(numbers.getFibonacci(n));

	}

	public int dynamicGetFibonacci(int n, int[] fibonaccis) {
		if (n <= 1) {
			fibonaccis[n] = n;
		}
		else {
			if (fibonaccis[n] < 0) {
				int result = dynamicGetFibonacci((n - 1), fibonaccis) + dynamicGetFibonacci((n - 2), fibonaccis);
				fibonaccis[n] = result;
			}
		}

		return fibonaccis[n];
	}

	public int getFibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		else {
			return getFibonacci(n - 1) + getFibonacci(n - 2);
		}
	}
}
