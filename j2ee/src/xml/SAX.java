package xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler
{
	private List<Book> books = null;
	private Book book = null;

	// 作用是记录解析时的上一个节点名称
	private String preTag = null;

	public List<Book> getBooks(InputStream xmlStream) throws Exception
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		SAX handler = new SAX();
		parser.parse(xmlStream, handler);
		return handler.getBooks();
	}

	public List<Book> getBooks()
	{
		return books;
	}

	@Override
	public void startDocument() throws SAXException
	{
		books = new ArrayList<Book>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		if ("book".equals(qName))
		{
			book = new Book();
			book.setId(Integer.parseInt(attributes.getValue(0)));
		}

		// 将正在解析的节点名称赋给preTag
		preTag = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		if ("book".equals(qName))
		{
			books.add(book);
			book = null;
		}

		/**
		 * 当解析结束时置为空。这里很重要，例如，当图中画3的位置结束后，会调用这个方法
		 * ，如果这里不把preTag置为null，根据startElement(....)方法，preTag的值还是book，当文档顺序读到图
		 * 中标记4的位置时，会执行characters(char[] ch, int start, int
		 * length)这个方法，而characters(....)方
		 * 法判断preTag!=null，会执行if判断的代码，这样就会把空值赋值给book，这不是我们想要的。
		 */
		preTag = null;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
		if (preTag != null)
		{
			String content = new String(ch, start, length);
			if ("name".equals(preTag))
			{
				book.setName(content);
			}
			else if ("price".equals(preTag))
			{
				book.setPrice(Float.parseFloat(content));
			}
		}
	}
}