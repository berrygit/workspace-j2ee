package concurrency.thread;

public class ThreadB implements Runnable {

	@Override
	public void run() {

		while (true) {
			System.out.println("BBBBBBB");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
