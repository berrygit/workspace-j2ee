package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4J
{

	public Document parse() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/xml/book.xml"));
		return document;
	}

	@SuppressWarnings("unchecked")
	public void travelDocument(Document document) throws DocumentException
	{
		Element root = document.getRootElement();

		// iterate through child elements of root
		for (Iterator<Element> i = root.elementIterator(); i.hasNext();)
		{
			Element element = i.next();
			System.out.println(element.getName());
		}

		// iterate through child elements of root with element name "name"
		for (Iterator<Element> i = root.elementIterator("name"); i.hasNext();)
		{
			Element name = i.next();
			System.out.println(name);
		}

		// iterate through attributes of root
		for (Iterator<Element> i = root.attributeIterator(); i.hasNext();)
		{
			Attribute attribute = (Attribute) i.next();
			System.out.println(attribute.getValue());
		}
	}

	@SuppressWarnings("unchecked")
	public void xPath(Document document)
	{
		List<Node> list = document.selectNodes("//books/book");
		for (Node i : list)
		{
			System.out.println(i.valueOf("@id"));
		}

		Node node = document.selectSingleNode("//books/book");
		String name = node.valueOf("@id");
		System.out.println(name);
	}

	public Document createDocument()
	{
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");

		// add
		root.addElement("author").addAttribute("name", "James")
		.addAttribute("location", "UK").addText("James Strachan");

		root.addElement("author").addAttribute("name", "Bob")
		.addAttribute("location", "US").addText("Bob McWhirter");

		return document;
	}

	public void write(Document document) throws IOException
	{
		// lets write to a file
		OutputFormat formatPretty = OutputFormat.createPrettyPrint();
		OutputFormat formatCompact = OutputFormat.createCompactFormat();

		XMLWriter writerPretty = new XMLWriter(
				new FileWriter("src/xml/output.xml"), formatPretty);
		XMLWriter writerCompact = new XMLWriter(System.out, formatCompact);
		writerPretty.write(document);
		writerPretty.close();

		writerCompact.write(document);
		writerCompact.close();
	}
}
