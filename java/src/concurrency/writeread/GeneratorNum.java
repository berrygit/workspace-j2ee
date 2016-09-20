package concurrency.writeread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneratorNum {
	public static void main(String[] args) throws IOException {
		Random rd = new Random();

		rd.nextInt(10000);

		BufferedWriter bw = new BufferedWriter(new FileWriter("demo.txt"));

		int count = 10000;

		while (count-- != 0) {
			bw.write(rd.nextInt(10000) + "\n");
		}
		bw.close();
	}
}
