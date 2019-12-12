package net.tf.javaee.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {
	Logger logger = Logger.getLogger(TestLog4j.class);
	@Test
	public void test() {
		logger.debug("mmm");
	}
}
