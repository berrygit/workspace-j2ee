//: concurrency/CaptureUncaughtException.java
package concurrency; /* Added by Eclipse.py */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {
	public void run() {
		throw new RuntimeException();
	}
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e + t.getName());
	}
}

class HandlerThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		return t;
	}
}

public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}
/*
 * Output: (90% match) HandlerThreadFactory@de6ced creating new
 * Thread created Thread[Thread-0,5,main] eh =
 * MyUncaughtExceptionHandler@1fb8ee3 run() by
 * Thread[Thread-0,5,main] eh =
 * MyUncaughtExceptionHandler@1fb8ee3 caught
 * java.lang.RuntimeException
 */// :~
