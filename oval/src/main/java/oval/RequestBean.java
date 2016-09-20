package oval;

import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

public class RequestBean {

	@NotNull(errorCode = "-1", message = "requestName can't be null")
	private String requestName;

	@Range(min = 20, max = 30, errorCode = "-2", message = "age must above 20 and below 30")
	private int age;

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
