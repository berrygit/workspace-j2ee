package bean.getbean.annotationbeans;

import org.springframework.stereotype.Component;

@Component
public class Person {

	@Override
	public String toString() {

		return "this is person";
	}
}
