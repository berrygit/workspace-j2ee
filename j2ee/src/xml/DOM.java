package xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM
{
	/**
	 * getBooks DOM方式解析XML文档
	 *
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	public List<Book> getBooks(InputStream inputStream) throws Exception
	{
		// jdk提供接口，将xml文件流转换为符合w3c标准的对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// w3c标准
		Document document = builder.parse(inputStream);
		Element element = document.getDocumentElement();

		// w3c标准的List，根据标签名获取元素
		NodeList bookNodes = element.getElementsByTagName("book");

		List<Book> list = new ArrayList<Book>();

		// 迭代子标签
		for (int i = 0; i < bookNodes.getLength(); i++)
		{
			// 解析book节点
			Element bookElement = (Element) bookNodes.item(i);
			Book book = new Book();
			book.setId(Integer.parseInt(bookElement.getAttribute("id")));

			// book子节点
			NodeList childNodes = bookElement.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++)
			{
				// 子节点类型为元素节点则处理，否则为文本空格
				if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE)
				{
					if ("name".equals(childNodes.item(j).getNodeName()))
					{
						book.setName(childNodes.item(j).getFirstChild()
								.getNodeValue());
					}
					else if ("price".equals(childNodes.item(j).getNodeName()))
					{
						book.setPrice(Float.parseFloat(childNodes.item(j)
								.getFirstChild().getNodeValue()));
					}
				}
			} // end for j

			list.add(book);

		} // end for i

		return list;
	}
}
