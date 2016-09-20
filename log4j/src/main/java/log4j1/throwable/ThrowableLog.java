package log4j1.throwable;

import org.apache.log4j.Logger;

public class ThrowableLog {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ThrowableLog.class);

		try {
			throw new NullPointerException("null pointer happen!");
		} catch (Throwable t) {
			logger.info("what happens?", t);
		}
	}
}
