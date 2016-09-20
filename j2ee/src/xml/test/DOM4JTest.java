package xml.test;

import java.io.IOException;

import org.dom4j.Document;
import org.junit.Test;

import xml.DOM4J;

public class DOM4JTest
{

	@Test
	public final void test()
	{
		DOM4J dom4j = new DOM4J();

		Document doc = dom4j.createDocument();
		try
		{
			dom4j.write(doc);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
