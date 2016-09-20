package bean.getbean.deadlock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//spring的ApplicationContextAware的setApplicationContext方法中调用applicationContext
//获取bean时并不保证bean是初始化好的，而是说明bean已经被实例化，否则是会死锁的。

@ComponentScan
public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new AnnotationConfigApplicationContext(Test.class);
		ac.getBean("beanA");
	}
}
