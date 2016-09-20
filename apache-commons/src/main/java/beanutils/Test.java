package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import bean.Person;

public class Test {

	public static void main(String[] args) {

		// 新创建一个普通Java Bean，用来作为被克隆的对象
		Person person1 = new Person();
		person1.setName("tom");
		person1.setAge(21);

		try {
			/*
			 * 克隆时，如果属性是private的，且没有get方法，那就不会被赋值。
			 */
			Person person2 = (Person) BeanUtils.cloneBean(person1);
			System.out.println(ToStringBuilder.reflectionToString(person2));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		// 原理也是通过Java的反射机制来做的。
		// 2、 将一个Map对象转化为一个Bean
		// 这个Map对象的key必须与Bean的属性相对应。
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "tom");
		map.put("email", "tom@");
		map.put("age", "21");

		// 将map转化为一个Person对象
		Person person3 = new Person();
		try {
			BeanUtils.populate(person3, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(ToStringBuilder.reflectionToString(person3));

		// 通过上面的一行代码，此时person的属性就已经具有了上面所赋的值了。
		// 将一个Bean转化为一个Map对象了，如下：
		try {
			Map<String, String> map2 = BeanUtils.describe(person3);
			System.out.println(ToStringBuilder.reflectionToString(map2));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
