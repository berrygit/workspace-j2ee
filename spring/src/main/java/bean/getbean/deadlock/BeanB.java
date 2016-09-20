package bean.getbean.deadlock;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("beanB");
		applicationContext.getBean("beanC");
	}

	@PostConstruct
	public void init() {
		System.out.println("bean B ok!");
	}

}
