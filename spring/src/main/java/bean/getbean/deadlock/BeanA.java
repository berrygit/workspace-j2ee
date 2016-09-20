package bean.getbean.deadlock;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("beanA");
		applicationContext.getBean("beanB");
	}

	@PostConstruct
	public void init() {
		System.out.println("bean A ok!");
	}
}
