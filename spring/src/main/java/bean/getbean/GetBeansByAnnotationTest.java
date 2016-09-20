package bean.getbean;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import bean.getbean.annotationbeans.Person;

//根据反射判断该类是否有ComponentScan注解，如果有则获取该类的路径，并加载路径下有Component注解的类
@ComponentScan
public class GetBeansByAnnotationTest {
	@SuppressWarnings({"resource"})
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(GetBeansByAnnotationTest.class);

		// 获取该路径下，所有类型为Person的bean。
		Map<String, Person> person = context.getBeansOfType(Person.class);

		for (Entry<String, Person> entry : person.entrySet()) {
			System.out.println(entry.getKey() + "    :    " + entry.getValue());
		}
	}
}
