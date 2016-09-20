package bean.getbean;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.pojobeans.Person;

public class GetBeansByPackageScanWithFilterTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring/application-context.xml");

		// 获取该路径下，所有类型为Person的bean。
		Map<String, Person> person = context.getBeansOfType(Person.class);

		for (Entry<String, Person> entry : person.entrySet()) {
			System.out.println(entry.getKey() + "    :    " + entry.getValue());
		}

		System.out.println(context.getBean("deskTop"));
	}

}
