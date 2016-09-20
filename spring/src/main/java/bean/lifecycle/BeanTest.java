package bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanTest
		implements
			BeanNameAware,
			BeanFactoryAware,
			ApplicationContextAware,
			InitializingBean,
			DisposableBean {

	/*
	 * 执行构造器
	 */
	public BeanTest() {
		System.out.println("BeanTest create");
	}

	/*
	 * BeanNameAware
	 * 
	 * @see org.springframework.beans.factory.BeanNameAware#
	 * setBeanName(java.lang.String)
	 */
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("call BeanNameAware interface name is:" + name);
	}

	/*
	 * BeanFactoryAware
	 * 
	 * @see org.springframework.beans.factory.BeanFactoryAware#
	 * setBeanFactory(org.springframework.beans.factory.
	 * BeanFactory)
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("call BeanFactoryAware interface");
	}

	/*
	 * ApplicationContextAware
	 * 
	 * @see org.springframework.context.ApplicationContextAware#
	 * setApplicationContext(org.springframework.context.
	 * ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("call ApplicationContextAware interface");
	}

	/*
	 * bean指定的初始化方法
	 */
	@PostConstruct
	public void _init() {
		System.out.println("call bean init method");
	}

	/*
	 * InitializingBean
	 * 
	 * @see org.springframework.beans.factory.InitializingBean#
	 * afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("call InitializingBean interface");

	}

	// 此时bean可以被开始使用

	/*
	 * bean指定的销毁方法
	 */
	@PreDestroy
	public void _destory() {
		System.out.println("call bean destory method");
	}

	/*
	 * DisposableBean
	 * 
	 * @see
	 * org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("call DisposableBean interface");
	}
}