package jmockit.behavior;

import org.testng.Assert;
import org.testng.annotations.Test;

import jmockit.behavior.MyObject;
import mockit.Expectations;
import mockit.Mocked;
/**
 * 黑盒MyObject
 * 
 * @author berry
 *
 */
public class MyObjectTest {

	@Mocked
	MyObject obj;

	@Test
	public void testHello() {
		new Expectations() {
			{
				obj.hello("wangwang");
				times = 1;
				result = "hello wangwang";
			}
		};

		Assert.assertEquals(obj.hello("wangwang"), "hello wangwang");

	}
}
