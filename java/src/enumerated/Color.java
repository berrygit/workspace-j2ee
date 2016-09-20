package enumerated;

public enum Color {

	// 必须先声明枚举
	RED("红色", 1), GREEN("绿色", 2), WHITE("白色", 3), YELLOW("黄色", 4);

	// 成员变量
	private String name;

	private int index;

	// 构造方法，只能是private
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (Color c : Color.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}
	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getColorName(Color color) {
		switch (color) {
			case RED :
				return "红";
			case WHITE :
				return "白";
			case GREEN :
				return "绿";
			case YELLOW :
				return "黄";
			default :
				return "未匹配";
		}
	}
}
