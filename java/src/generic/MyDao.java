package generic;

public class MyDao extends SystemDao<Fruit> {
	public static void main(String[] args) {
		Fruit f = new Fruit();
		f.setColor("yellow");
		f.setName("banana");
		System.out.println(new MyDao().phrase(f));
	}
}
