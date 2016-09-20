package annotaiton;

public class Apple {

	@FruitName("Apple")
	private String appleName;

	/**
	 * 注解元素必须有确定的值，要么在定义注解的默认值中指定，要么在使用注解时指定，非基本类型的注解元素的值不可为null。
	 */
	@FruitColor("yellow")
	private String appleColor;
}
