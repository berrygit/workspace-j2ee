package bean.getbean.annotationbeans;

import org.springframework.stereotype.Component;

@Component
public class American extends Person {

	@Override
	public String toString() {
		return "this is american";
	}
}
