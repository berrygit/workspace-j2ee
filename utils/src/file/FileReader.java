package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

	BufferedReader in = null;

	public FileReader(String fileName) throws IOException {
		File dir = new File(".");
		File fin = new File(dir.getCanonicalPath() + File.separator + "code.txt");

		FileInputStream fis = new FileInputStream(fin);

		in = new BufferedReader(new InputStreamReader(fis));
	}

	public String readFileByLine() throws IOException {

		String aLine = null;
		while ((aLine = in.readLine()) != null) {
			if (aLine.trim().length() == 0) {
				return aLine;
			}
		}

		return null;
	}

	public void close() throws IOException {
		in.close();
	}
}
