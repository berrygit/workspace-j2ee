package concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
	}
}
