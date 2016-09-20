package lang3.tostring;

import org.apache.commons.lang3.builder.ToStringBuilder;

import bean.Chinese;

/*
 * 常规的tostring方法，如果手动写一是很繁琐，浪费时间，简单机械。另一个大量拼接字符串
 * 也会造成一定的性能问题。toStringBuilder提供了灵活的高效的方式，通过配置可以指定打印
 * 的样式以及是否打印一些字段，打印到继承的哪一层。也使代码更加清爽，防止空指针错误等。
 * 
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(ToStringBuilder.reflectionToString(new Chinese()));
		System.out.println(ToStringBuilder.reflectionToString(new Chinese(), null, false, Chinese.class));
	}
}
