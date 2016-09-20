package concurrency.thread;

public class ThreadA implements Runnable {

	@Override
	public void run() {

		while (true) {
			System.out.println("AAAAAAA");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
