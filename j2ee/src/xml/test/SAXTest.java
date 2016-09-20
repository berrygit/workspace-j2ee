package xml.test;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import xml.Book;
import xml.SAX;

public class SAXTest
{

	@Test
	public final void test() throws Exception
	{

		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream("book.xml");

		SAX sax = new SAX();
		List<Book> books = sax.getBooks(input);
		for (Book book : books)
		{
			System.out.println(book.toString());
		}
	}
}
