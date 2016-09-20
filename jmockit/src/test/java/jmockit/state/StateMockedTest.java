package jmockit.state;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Mock;
import mockit.MockUp;

/**
 * 白盒StateMocked
 * 
 * @author berry
 *
 */
public class StateMockedTest {

	@Test
	public void testMockNormalMethodContent() throws IOException {
		StateMocked obj = new StateMocked();

		new MockUp<StateMocked>() {
			@Mock
			public int getTriple(int i) {
				return i * 30;
			}
		};

		Assert.assertEquals(30, obj.getTriple(1));
		Assert.assertEquals(60, obj.getTriple(2));
	}
}
