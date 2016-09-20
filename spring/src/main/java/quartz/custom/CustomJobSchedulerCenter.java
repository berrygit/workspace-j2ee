package quartz.custom;

import java.text.ParseException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import quartz.annotation.CronExpression;

public class CustomJobSchedulerCenter implements ApplicationContextAware {

	private Map<String, Task> taskMap;

	private ApplicationContext applicationContext;

	public void init() throws ParseException, SchedulerException {
		Set<Entry<String, Task>> entrys = taskMap.entrySet();
		SchedulerFactoryBean schedulerFactoryBean = (SchedulerFactoryBean) applicationContext
				.getBeansOfType(SchedulerFactoryBean.class).entrySet().iterator().next().getValue();

		for (Entry<String, Task> entry : entrys) {

			String taskName = entry.getKey();
			Task task = entry.getValue();
			CronExpression ce = task.getClass().getAnnotation(CronExpression.class);
			String croExpression = ce.value();
			JobDetail jobDetail = JobBuilder.newJob(TagJob.class).withIdentity(taskName).build();;
			jobDetail.getJobDataMap().put("task", task);
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(taskName)
					.withSchedule(CronScheduleBuilder.cronSchedule(croExpression)).build();
			schedulerFactoryBean.getScheduler().scheduleJob(jobDetail, trigger);
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		taskMap = applicationContext.getBeansOfType(Task.class);
	}
}
