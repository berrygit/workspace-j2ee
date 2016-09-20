package dynamic;

import java.util.Arrays;

import array.ArrayTool;

/**
 * 买书问题，同时买多本不一样的书会打折，本数越多这款越大，但要求这些书中不能有相同的书。
 * 使用动态规划算法解决，将大问题分类为小问题，然后运用递归从底向上解决。
 * 
 * @author berry
 *
 */
public class BuyBook {

	private final int BOOK_PRICE = 8;

	public static void main(String[] args) {

		int[] bookOrder = new int[5];

		bookOrder[0] = 2;
		bookOrder[1] = 2;
		bookOrder[2] = 2;
		bookOrder[3] = 1;
		bookOrder[4] = 1;
		Arrays.sort(bookOrder);
		ArrayTool.print(bookOrder);
		BuyBook buy = new BuyBook();
		System.out.println(buy.cost(bookOrder));

	}
	public double cost(int[] bookOrder) {

		assert (bookOrder != null && bookOrder.length > 0);

		ArrayTool.print(bookOrder);

		// 没有订单信息直接返回
		if (isOrderEmpty(bookOrder)) {
			return 0;
		}

		// 先买五本
		double buyFiveCost = Integer.MAX_VALUE;
		if (bookOrder[0] > 0) {
			int[] cloneBookOrders = bookOrder.clone();

			buyOneFromLastToPosition(cloneBookOrders, 0);
			buyFiveCost = (5 * BOOK_PRICE * 0.75) + cost(cloneBookOrders);
		}

		double buyFourCost = Integer.MAX_VALUE;
		if (bookOrder[1] > 0) {
			int[] cloneBookOrders = bookOrder.clone();

			buyOneFromLastToPosition(cloneBookOrders, 1);
			Arrays.sort(cloneBookOrders);
			buyFourCost = (4 * BOOK_PRICE * 0.8) + cost(cloneBookOrders);
		}

		double buyThreeCost = Integer.MAX_VALUE;
		if (bookOrder[2] > 0) {
			int[] cloneBookOrders = bookOrder.clone();

			buyOneFromLastToPosition(cloneBookOrders, 2);
			Arrays.sort(cloneBookOrders);
			buyThreeCost = (3 * BOOK_PRICE * 0.9) + cost(cloneBookOrders);
		}

		double buyTwoCost = Integer.MAX_VALUE;
		if (bookOrder[3] > 0) {
			int[] cloneBookOrders = bookOrder.clone();

			buyOneFromLastToPosition(cloneBookOrders, 3);
			Arrays.sort(cloneBookOrders);
			buyTwoCost = (2 * BOOK_PRICE * 0.95) + cost(cloneBookOrders);
		}

		double buyOneCost = Integer.MAX_VALUE;
		if (bookOrder[4] > 0) {
			int[] cloneBookOrders = bookOrder.clone();

			buyOneFromLastToPosition(cloneBookOrders, 4);
			Arrays.sort(cloneBookOrders);
			buyOneCost = BOOK_PRICE + cost(cloneBookOrders);
		}

		return Math.min(buyFiveCost, Math.min(buyFourCost, Math.min(buyThreeCost, Math.min(buyOneCost, buyTwoCost))));
	}
	private void buyOneFromLastToPosition(int[] bookOrder, int position) {

		for (int i = bookOrder.length - 1; i >= position; i--) {
			bookOrder[i] = bookOrder[i] - 1;
		}
	}

	private boolean isOrderEmpty(int[] bookOrder) {

		for (int i = 0; i < bookOrder.length; i++) {
			if (bookOrder[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
