package test;

import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		final Test t = new Test();

		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("enter thread");
					TimeUnit.SECONDS.sleep(1);

					synchronized (t) {
						System.out.println("enter lock");
						TimeUnit.SECONDS.sleep(11);
						System.out.println("finish 11 second");
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		a.start();

		synchronized (t) {
			System.out.println("enter wait method");
			t.wait(2000);
			System.out.println("finish 2 second");
		}
	}
}
