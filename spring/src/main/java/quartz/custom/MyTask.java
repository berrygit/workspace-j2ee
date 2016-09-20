package quartz.custom;

import quartz.annotation.CronExpression;

@CronExpression("3 * * * * ?")
public class MyTask implements Task {

	@Override
	public void run() {
		System.out.println("this is my task");
	}
}
