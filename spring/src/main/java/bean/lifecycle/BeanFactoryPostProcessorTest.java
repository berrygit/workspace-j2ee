package bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/*
 * spring容器初始化后，会调用实现了BeanFactoryPostProcessor接口的类。容器初始化时定义了bean的名字，但并未初始化。
 */
@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("------> begin BeanFactoryPostProcessorTest<-------");
		String[] names = beanFactory.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("definition bean name:" + name);
		}
		System.out.println("<------ end BeanFactoryPostProcessorTest------->");
	}

}
