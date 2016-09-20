package concurrency.testfinal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {

	private Node n = new Node();

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(1);
		Test t = new Test();

		for (int i = 0; i < 1000; i++) {

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						latch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (t.n.node.b != 100) {
						System.out.println("wrong!");
					}
				}
			}).start();
		}
		while (Thread.activeCount() < 1000) {
			TimeUnit.MICROSECONDS.sleep(2);
		}
		latch.countDown();
		t.n.set();

		System.out.println("finish");
	}

	class Node {
		private int a = 0;

		private Node2 node = new Node2();

		public void set() {
			node.b = 100;
		}
	}

	class Node2 {
		private int b;
		public Node2() {
			b = 10;
		}
	}
}
