package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunClass {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newScheduledThreadPool(5);
		exec.execute(new MyThread());

		// 防止继续添加线程
		exec.shutdown();
	}
}
