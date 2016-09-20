package innerclass;

public class StaticMember {
	public static int x = 100;
	private int b = 10;
	public static class MyInner {
		private String y = "Hello!";
		public void innerMethod() {
			System.out.println("x=" + x);
			System.out.println("y=" + y);
		}
	}

	public static void main(String[] args) {

		// 静态内部类不通过外部实例就可以创建对象；与类变量可以通过类名访问相似
		StaticMember.MyInner si = new StaticMember.MyInner();
		si.innerMethod();
	}
}