package bean.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

@ComponentScan
public class Test {

	@SuppressWarnings({"resource", "unused"})
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);

		// 此时初始化好的bean可以被使用
		BeanTest printer = context.getBean(BeanTest.class);

		// bean的销毁方法是在容器准备关闭时才进行的
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}