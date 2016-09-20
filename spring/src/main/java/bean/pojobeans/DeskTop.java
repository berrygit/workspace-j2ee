package bean.pojobeans;

import org.springframework.stereotype.Component;

//beanname默认为类名的首字母变小写
@Component
public class DeskTop {
	@Override
	public String toString() {
		return "i am just a desktop!";
	}
}
