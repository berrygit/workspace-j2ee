package bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/*
 * 在每个bean的生成过程中，spring都会调用实现了BeanPostProcessor接口的类的两个方法。
 */
@Component
public class BeanPostProcessorTest implements BeanPostProcessor {

	// 这个方法执行之后，bean将被使用
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("call After init:" + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("call Before init:" + beanName);
		if (bean instanceof BeanTest) {
			System.out.println("bean instanceof BeanTest");
		}
		return bean;
	}

}
