package quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ExampleJob extends QuartzJobBean {

	private int timeout;

	/**
	 * Setter called after the ExampleJob is instantiated with
	 * the value from the JobDetailFactoryBean (5)
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		// 获取job执行所需要的一些信息。
		System.out.println(ctx.getJobDetail().getJobDataMap().get("timeout"));
		System.out.println("hello everyone");
		// 如果属性中有该字段，会自动完成装配到属性
		System.out.println(timeout);
	}
}
