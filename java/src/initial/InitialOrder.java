package initial;

class InitialOrder implements Cloneable {
	public static int k = 0;
	public static InitialOrder t1 = new InitialOrder("t1");
	public static InitialOrder t2 = new InitialOrder("t2");
	public static int i = print("i");
	public static int n = 99;

	public int j = print("j");

	{
		print("构造块");
	}

	static {
		print("静态块");
	}

	public InitialOrder(String str) {
		System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
		++n;
		++i;
	}

	public static int print(String str) {
		System.out.println((++k) + ":" + str + "   i=" + i + "   n=" + n);
		++n;
		return ++i;
	}

	public static void main(String[] args) {
		InitialOrder t = new InitialOrder("init");
	}

}
