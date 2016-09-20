package set;

public class BitMapSet {

	private int[] set = new int[4000000];

	/**
	 * 清空
	 */
	public void clear() {

		for (int i = 0; i < set.length; i++) {
			set[i] = 0;
		}
	}

	/**
	 * 添加
	 * 
	 * @param i
	 */
	public void add(int i) {
		int sub = i / 32;
		int positon = i % 32;
		set[sub] = set[sub] | (1 << positon);
	}

	/**
	 * 判断是否存在某个整数
	 * 
	 * @param i
	 * @return
	 */
	public boolean exist(int i) {
		int sub = i / 32;
		int positon = i % 32;

		if ((set[sub] & (1 << positon)) != 0) {
			return true;
		} else {
			return false;
		}

	}
}
