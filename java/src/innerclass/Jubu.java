package innerclass;

public class Jubu {
	private int size = 5;
	private int y = 7;
	public Object makeInner(int localVar) {
		final int finalLocalVar = localVar;
		// 创建内部类，该类只在makeInner（）方法有效，就像局部变量一样。在方法体外部不能创建MyInner类的对象
		class MyInner {
			int y = 4;
			public String toString() {
				size++;
				return "OuterSize:" + size + "\nfinalLocalVar" + " " + "this.y=" + this.y;
			}
		}
		return new MyInner();
	}
}

class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 创建Jubu对象obj，并调用它的makeInner（）方法，该方法返回一个
		Object obj = new Jubu().makeInner(47);
		// 该方法返回一个MyInner类型的的对象obj，然后调用其同toString方法。
		System.out.println(obj.toString());
	}
}
