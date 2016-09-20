package concurrency.writeread;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteThread implements Runnable {

	private BufferedReader br = null;
	private List<String> list;

	public ReadWriteThread(BufferedReader br) {
		this.br = br;
	}

	public void run() {
		String line = null;
		int count = 0;
		System.out.println(Thread.currentThread().getName());
		this.list = new ArrayList<String>();
		try {
			while ((line = br.readLine()) != null) {

				if (count < 10) {
					list.add(line);
					count++;
				}
				else {
					list.add(line);
					count = 0;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
