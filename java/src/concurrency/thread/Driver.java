package concurrency.thread;

public class Driver {
	public static void main(String[] args) {
		Thread a = new Thread(new ThreadA());
		Thread b = new Thread(new ThreadB());
		a.start();
		b.start();
	}
}
