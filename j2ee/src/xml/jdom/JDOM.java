package xml.jdom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class JDOM {
	public static void main(String args[]) throws Exception {

		SAXBuilder builder = new SAXBuilder();

		// 从文件构造一个document，因为xml文件中已经指定了编码，所以这里不必了
		Document doc = builder.build(new FileInputStream("src/xml/jdom/book.xml"));

		// 得到根元素
		Element root = doc.getRootElement();

		// 得到根元素所有子元素的集合
		List<Element> books = root.getChildren();
		Element book = books.get(0); // 得到第一个book元素

		// 为第一本书添加一条属性
		Attribute a = new Attribute("hot", "true");
		book.setAttribute(a);

		// 得到指定的字元素
		Element author = book.getChild("name");

		// 将作者改为王五
		author.setText("王五");

		// 或 text t = new text("王五");book.addcontent(t);
		Element price = book.getChild("price"); // 得到指定的字元素

		// 修改价格，比较郁闷的是我们必须自己转换数据类型，而这正是jaxb的优势
		price.setText(Float.toString(50.0f));

		XMLOutputter outp = new XMLOutputter();
		outp.output(doc, new FileOutputStream("src/xml/jdom/example.xml"));
	}
}
