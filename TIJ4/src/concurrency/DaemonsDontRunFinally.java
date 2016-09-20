//: concurrency/DaemonsDontRunFinally.java
package concurrency; /* Added by Eclipse.py */

import static net.mindview.util.Print.print;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable {
	public void run() {
		while (true) {
			try {
				print("Starting ADaemon");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				print("Exiting via InterruptedException");
			} finally {
				print("This should always run?");
			}
		}

	}
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
		t.join(1000);
		TimeUnit.SECONDS.sleep(10);
	}
}
/*
 * Output: Starting ADaemon
 */// :~
