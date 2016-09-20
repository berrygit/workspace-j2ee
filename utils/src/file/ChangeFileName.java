package file;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author berry
 */
public class ChangeFileName
{

	private static final String directory = "/home/berry/nlp";

	public static void main(String[] args) throws UnsupportedEncodingException
	{
		File catalog = new File(directory);

		if (catalog != null)
		{
			File[] files = catalog.listFiles();

			if (files != null)
			{
				for (File file : files)
				{
					changeFileName(file);
				}
			}
		}

	}

	private static void deleteRepeate(File[] files)
	{
		if (files == null)
		{
			return;
		}

		for (File file : files)
		{
			for (File fileAgain : files)
			{
				if (file.getName().equals(fileAgain.getName() + ".1"))
				{
					System.out.println("find");
				}
			}
		}
	}

	/**
	 * @param file
	 * @throws UnsupportedEncodingException
	 */
	private static void changeFileName(File file)
			throws UnsupportedEncodingException
	{
		if (file.isDirectory())
		{
			return;
		}

		String fileName = file.getName();

		// System.out.println(fileName);

		String newFileName = URLDecoder.decode(fileName, "utf-8");

		// String newFileName = fileName.substring(fileName.length() / 2);
		// System.out.println(newFileName);

		if (!fileName.equals(newFileName))
		{
			System.out.println(fileName);
			System.out.println(newFileName);
			renameFile(directory, fileName, newFileName);
		}

	}

	/** */
	/**
	 * 文件重命名
	 * 
	 * @param path
	 *            文件目录
	 * @param oldname
	 *            原来的文件名
	 * @param newname
	 *            新文件名
	 */
	public static void renameFile(String path, String oldname, String newname)
	{
		if (!oldname.equals(newname))
		{
			// 新的文件名和以前文件名不同时,才有必要进行重命名
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (!oldfile.exists())
			{
				return;// 重命名文件不存在
			}
			if (newfile.exists())// 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
				System.out.println(newname + "已经存在！");
			else
			{
				oldfile.renameTo(newfile);
			}
		}
		else
		{
			System.out.println("新文件名和旧文件名相同...");
		}
	}
}
