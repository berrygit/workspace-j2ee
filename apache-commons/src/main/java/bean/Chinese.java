package bean;

import java.util.ArrayList;
import java.util.List;

public class Chinese extends Person {

	private List<Cat> cats = new ArrayList<Cat>();

	{
		cats.add(new Cat("mial"));
		cats.add(new Cat("dd"));
		cats.add(new Cat("tt"));
		cats.add(new Cat("hh"));
	}
}
