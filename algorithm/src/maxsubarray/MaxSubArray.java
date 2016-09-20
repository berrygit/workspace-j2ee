package maxsubarray;

import array.ArrayTool;

/**
 * 
 * 计算股票收益最大值，先将每个点的后点的值减去前点的值，得到数组的子数组最大和就是原始股票问题中最高点减去最低的值，
 * 即股票的最大收益 。
 * 
 * @author berry
 * 
 */
public class MaxSubArray {
	static int[] numbers = {17, 63, 43, 64, 58, 54, 97, 65, 7, 2, 65, 67, 95, 34, 5, 976, 465, 35, 34, 64, 34, 643, 15,
			23, 1, 46, 32, 35, 345, 23, 9, 4, 62, 234, 77};

	public static void main(String[] args) {
		int length = numbers.length - 1;
		int[] underDealArray = new int[length];

		for (int i = 0; i < underDealArray.length; i++) {
			underDealArray[i] = numbers[i + 1] - numbers[i];
		}

		underDealArray = new int[]{-9, 3, -5, -7};

		ArrayTool.print(underDealArray);

		MaxInfo result = new MaxSubArray().findByDivide(underDealArray, 0, underDealArray.length - 1);
		System.out.println("left: " + result.left + ", right: " + result.right + ", maxsum: " + result.maxSum + ".");
		result = new MaxSubArray().findBySearch(underDealArray);
		System.out.println("left: " + result.left + ", right: " + result.right + ", maxsum: " + result.maxSum + ".");

	}
	/**
	 * 分治
	 * 
	 * @param array
	 * @param begin
	 * @param end
	 * @return
	 */
	private MaxInfo findByDivide(int[] array, int begin, int end) {

		assert (array != null) : "array can't be null.";
		assert (begin >= 0 && begin <= end && end <= array.length - 1) : "begin=" + begin + ", end=" + end
				+ ", (array.length - 1)=" + (array.length - 1) + ".";

		if (end == begin) {
			return new MaxInfo(begin, end, array[begin]);
		}
		else {
			int mid = (begin + end) / 2;

			// 三种情况：左边的，右边的，跨过中间两个元素。
			MaxInfo leftMax = findByDivide(array, begin, mid);
			MaxInfo rightMax = findByDivide(array, mid + 1, end);
			MaxInfo crossMax = maxCrossSum(array, begin, mid, end);

			if (leftMax.maxSum >= rightMax.maxSum && leftMax.maxSum >= crossMax.maxSum) {
				return leftMax;
			}
			else if (rightMax.maxSum >= leftMax.maxSum && rightMax.maxSum >= crossMax.maxSum) {
				return rightMax;
			}
			else {
				return crossMax;
			}
		}
	}

	/**
	 * 跨过中间两个元素
	 * 
	 * @param array
	 * @param begin
	 * @param mid
	 * @param end
	 * @return
	 */
	private MaxInfo maxCrossSum(int[] array, int begin, int mid, int end) {

		assert (array != null) : "array can't be null.";
		assert (begin >= 0 && begin <= mid && mid < end && end <= array.length - 1) : "begin=" + begin + ", mid=" + mid
				+ ", end=" + end + ", (array.length - 1)=" + (array.length - 1) + ".";

		// 先向左搜索
		int left = mid;
		int leftSum = array[mid];
		int tempSum = leftSum;

		for (int i = mid - 1; i >= begin; i--) {
			tempSum = tempSum + array[i];
			if (tempSum > leftSum) {
				leftSum = tempSum;
				left = i;
			}
		}

		// 再向右搜索
		int right = mid + 1;
		int rightSum = array[mid + 1];
		tempSum = rightSum;

		for (int i = mid + 2; i <= end; i++) {
			tempSum = tempSum + array[i];
			if (tempSum > rightSum) {
				rightSum = tempSum;
				right = i;
			}
		}

		return new MaxInfo(left, right, leftSum + rightSum);
	}

	/**
	 * 
	 * 扫描寻找最大值，将大问题逐步缩小求解
	 * 
	 * @param array
	 * @return
	 */
	private MaxInfo findBySearch(int[] array) {

		int maxSofar = Integer.MIN_VALUE;
		int maxEndingHere = Integer.MIN_VALUE;

		int begin = 0;
		int end = 0;
		int tempBegin = 0;

		for (int i = 0; i < array.length; i++) {

			// 如果前一次的maxEnding最大值小于零，则需要舍去，本次maxEnding最大值就是下标所指元素
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				tempBegin = i;
			}
			maxEndingHere = maxEndingHere + array[i];

			// 每次比较最大值
			if (maxSofar < maxEndingHere) {
				maxSofar = maxEndingHere;
				begin = tempBegin;
				end = i;
			}
		}

		return new MaxInfo(begin, end, maxSofar);
	}
}
