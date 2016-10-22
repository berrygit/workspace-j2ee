package structural.proxy.dynamic_proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {

		PersonBean person = new PersonBeanImpl();
		System.out.println(person.getClass().getName());

		PersonBean proxy = getProxy(person);
		System.out.println(proxy.getClass().getName());

		System.out.println(proxy instanceof PersonBean);
	}

	private static PersonBean getProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(PersonBeanImpl.class.getClassLoader(),
				person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
	}
}
