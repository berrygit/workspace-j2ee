package quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzJobTest {

	public static void main(String[] args) {
		@SuppressWarnings({"unused", "resource"})
		ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring/spring-quartz.xml");
	}
}
