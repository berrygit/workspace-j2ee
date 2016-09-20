package bean;

import java.util.List;

public class Person {
	private String name = "";
	@SuppressWarnings("unused")
	private String email = "";

	@SuppressWarnings("unused")
	private int age;

	@SuppressWarnings("unused")
	private List<Dog> dogs = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
