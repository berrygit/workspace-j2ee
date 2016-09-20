package math;

import java.util.Random;

import algorithm.AlgorithmTool;

public class RandomNum {

	/**
	 * generate随机数字数组生成器，范围在入参scope内
	 *
	 * @return 含随机数长度为number的数组
	 */
	public static int[] generate(int scope) {
		int[] numbers = new int[scope];

		for (int i = 0; i < numbers.length; i++) {
			// 产生scope范围内的随机数
			numbers[i] = new Random().nextInt(scope);
		}

		return numbers;
	}

	/**
	 * 返回[low,high]区间内的均匀概率下的一个整型数字取样
	 *
	 * @return low到high闭区间内的一个整型数字取样
	 */
	public static int generate(int low, int high) {

		// nextInt(n)函数返回[0,n)区间内的均匀概率下单次整型数字取样
		return low + new Random().nextInt(high - low + 1);
	}

	/**
	 * 传入一个数组，打乱传入数组中元素的顺序，end标示数组中元素的结束位置（位置从0开始计）
	 * 
	 * @param numbers
	 */
	public static void upsetOrder(int[] numbers, int end) {

		// 参数校验
		if (numbers == null) {
			throw new IllegalArgumentException("numbers argument shouldn't be null.");
		}

		if (end < 0) {
			throw new IllegalArgumentException("the end argument should't be less than 0.");
		}

		// 逐个位置打乱，类似于抽签，每个位置获取每个数字的概率均相等
		for (int i = 0; i < end; i++) {

			int randomPosition = generate(i, end);
			AlgorithmTool.swap(numbers, i, randomPosition);
		}
	}

	public static void main(String[] args) {
		int[] test = new int[]{1, 2, 3, 4, 5, 6};
		upsetOrder(test, 5);

		for (int a : test) {
			System.out.print(a);
		}
	}
}
