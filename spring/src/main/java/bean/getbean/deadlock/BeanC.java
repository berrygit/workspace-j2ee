package bean.getbean.deadlock;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanC implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("beanC");
		applicationContext.getBean("beanA");
	}

	@PostConstruct
	public void init() {
		System.out.println("bean C ok!");
	}

}
