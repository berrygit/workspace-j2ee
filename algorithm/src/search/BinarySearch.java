package search;

/**
 * 时间复杂度O(log2n)
 * 
 * @author berry
 *
 */
public class BinarySearch {

	public int find(int[] datas, int data) {

		if (datas == null) {
			throw new IllegalArgumentException("datas argument sholdn't be null.");
		}

		int position = -1;

		int begin = 0;
		int end = datas.length - 1;

		int mid = 0;

		while (begin <= end) {

			mid = (begin + end) / 2;

			if (datas[mid] == data) {
				position = mid;
				break;
			} else if (datas[mid] > data) {
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}

		return position;
	}

	public static void main(String[] args) {
		int[] datas = new int[]{1, 3, 5, 7, 8, 9, 22};

		System.out.println(new BinarySearch().find(datas, 0));
	}
}
