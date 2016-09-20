package generic;

import java.lang.reflect.Field;

public class SystemDao<E> {

	public String phrase(E entity) {
		Class<?> clz = entity.getClass();

		String a = "" + clz.getSimpleName() + " ";

		for (Field field : clz.getDeclaredFields()) {
			field.setAccessible(true);
			try {
				a += field.getName() + " " + field.get(entity) + " ";
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}
}
