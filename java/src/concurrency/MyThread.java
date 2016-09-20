package concurrency;

public class MyThread implements Runnable {

	@Override
	public void run() {
		int i = 10;
		while (--i > 0) {
			System.out.println("hell word!");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		MyThread mt = new MyThread();
		Thread t = new Thread(mt);

		t.start();
		while (true) {
			System.out.println("hh");
			Thread.sleep(2000);
		}
	}
}
