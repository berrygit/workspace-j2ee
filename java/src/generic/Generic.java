package generic;

import java.util.ArrayList;
import java.util.List;

public class Generic<E> {

	@SuppressWarnings("unchecked")
	E[] elements = (E[]) new Object[10];
	E rrr = elements[0];

	public void add(E e) {
	}

	private static List<?> list = new ArrayList<String>();

	public static void main(String[] args) {
		new Generic<Object>().add(new Fruit());;

	}
}
