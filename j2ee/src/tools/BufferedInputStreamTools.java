package tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamTools
{
	public static void bufferedReadToFile(File file, BufferedInputStream bi,
			int length) throws IOException
	{

		if (length <= 0)
		{
			return;
		}

		// 缓冲
		byte[] b = new byte[length];

		// 读流
		bi.read(b);
		bi.close();

		// 写文件
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(b);
		fo.flush();
		fo.close();
	}

}
