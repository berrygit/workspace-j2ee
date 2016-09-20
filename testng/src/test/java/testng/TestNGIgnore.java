package testng;

import org.testng.annotations.Test;

public class TestNGIgnore {

	@Test(enabled = false)
	public void testIgnore() {
		System.out.println("This test case will ignore");
	}
}
