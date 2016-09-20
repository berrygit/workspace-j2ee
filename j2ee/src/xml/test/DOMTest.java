package xml.test;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import xml.Book;
import xml.DOM;

public class DOMTest
{

	@Test
	public final void test() throws Exception
	{
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream("book.xml");

		List<Book> books = new DOM().getBooks(input);
		for (Book book : books)
		{
			System.out.println(book.toString());
		}
	}

}
