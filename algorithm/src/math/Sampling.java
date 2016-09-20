package math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import algorithm.AlgorithmTool;
import argument.ListTool;

/**
 * 无论是Knuth还是Floyd的取样算法，抽签思想都是保证抽取样本等概率的保证，两个算法都很巧妙，
 * 都尽可能的减少随机数生成的次数（热点）。
 * 其中Floyd算法只需要做M次的随机数生成，而Knuth要做N次，这是二者最大的差别。
 * Floyd算法是一种把抽签行为倒置的过程，值得玩味。
 * 
 * @author berry
 *
 */
public class Sampling {

	private List<String> collectivityList = null;

	private final int collectivityCapacity;

	/**
	 * 以List形式放入待抽样数据
	 * 
	 * @param collectivityList
	 */
	Sampling(List<String> collectivityList) {

		if (ListTool.isNullOrEmpty(collectivityList)) {
			throw new IllegalArgumentException("collectivityList argument sholdn't be null or empty.");
		}

		// 初始化collectivityList
		this.collectivityList = collectivityList;

		// 总体的容量
		collectivityCapacity = collectivityList.size();

	}

	/**
	 * 无序等概率选取selectNum个样本，selectNum应该大于0，并且小于总体的数量
	 * 
	 * @param selectNum
	 */
	public void unorderSelectByKnuth(int selectNum) {

		// 校验参数
		if (selectNum <= 0 || selectNum >= collectivityCapacity) {
			throw new IllegalArgumentException(
					"selectNum argument shouldn't be less than 0 or bigger than collectivityCapacity");
		}

		// 初始化collectivityArray，该数组用于随机抽样
		int[] collectivityArray = new int[collectivityCapacity];
		for (int i = 0; i < collectivityCapacity; i++) {
			collectivityArray[i] = i;
		}

		// 随机抽样
		for (int i = 0; i < selectNum; i++) {
			AlgorithmTool.swap(collectivityArray, i, RandomNum.generate(i, collectivityCapacity - 1));
			System.out.println(collectivityList.get(collectivityArray[i]));
		}
	}

	/**
	 * 按顺序等概率选取selectNum个样本，selectNum应该大于0，并且小于总体的数量
	 * 
	 * @param selectNum
	 */
	public void orderSelectByKnuth(int selectNum) {

		// 校验参数
		if (selectNum <= 0 || selectNum >= collectivityCapacity) {
			throw new IllegalArgumentException(
					"selectNum argument shouldn't be less than 0 or bigger than collectivityCapacity");
		}

		// 抽签式选取selectNum个样本
		int remaining = collectivityCapacity;
		for (String in : collectivityList) {
			if ((Math.abs(new Random().nextInt()) % remaining) < selectNum) {
				System.out.println(in);
				selectNum--;
			}
			remaining--;
		}
	}

	/**
	 * 按顺序等概率选取selectNum个样本，selectNum应该大于0，并且小于总体的数量
	 * 
	 * @param selectNum
	 */
	public void orderSelectByFloyd(int selectNum) {

		// 校验参数
		if (selectNum <= 0 || selectNum >= collectivityCapacity) {
			throw new IllegalArgumentException(
					"selectNum argument shouldn't be less than 0 or bigger than collectivityCapacity");
		}

		Set<Integer> sampleSet = new HashSet<Integer>();

		// 逆抽签式选取selectNum个样本
		for (int i = collectivityCapacity - selectNum; i < collectivityCapacity; i++) {
			int randomPosition = RandomNum.generate(0, i);
			if (sampleSet.contains(randomPosition)) {
				sampleSet.add(i);
			} else {
				sampleSet.add(randomPosition);
			}
		}

		for (Integer position : sampleSet) {
			System.out.println(collectivityList.get(position));
		}
	}

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();

		names.add("wenlinguo");
		names.add("qianyiyong");
		names.add("zhaofeng");
		names.add("liuqianqian");
		names.add("chenmeng");

		new Sampling(names).orderSelectByFloyd(5);

	}
}
