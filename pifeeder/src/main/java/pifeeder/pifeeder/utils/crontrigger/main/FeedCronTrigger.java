package pifeeder.pifeeder.utils.crontrigger.main;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;

import pifeeder.pifeeder.utils.crontrigger.jobs.FeedJob;
import pifeeder.pifeeder.utils.parameter.ParamManager;

public class FeedCronTrigger {
		
	/** Holder */
	private static class FeedCronTriggerManager {
		/** Instance unique non préinitialisée */
		private final static FeedCronTrigger instance = new FeedCronTrigger();
	}

	/** Point d'accès pour l'instance unique du singleton */
	public static FeedCronTrigger getInstance() {
		return FeedCronTriggerManager.instance;
	}

	private JobDetail job;
	
	public void setJob(JobDetail job) {
		this.job = job;
	}
	
	public JobDetail getJob() {
		return job;
	}
	
	private FeedCronTrigger() {
		setJob(JobBuilder.newJob(FeedJob.class).withIdentity("FeedJob", "group1").build());
	}
	
	public void start(String cron){
		//Test validité cron
		if(!CronExpression.isValidExpression(cron)){			
			cron = ParamManager.getInstance().getParameter().DEFAULTTIMETOFEED;
			LoggerFactory.getLogger(this.getClass()).info("Cron invalide!");
		}
		
		
	   	Trigger trigger = TriggerBuilder
		.newTrigger()
		.withIdentity("FeedTrigger", "group1")
		.withSchedule(
			CronScheduleBuilder.cronSchedule(cron))
		.build();
	   		   	
    	//schedule it
    	Scheduler scheduler;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
	    	scheduler.scheduleJob(getJob(), trigger);
		} catch (SchedulerException e) {
			LoggerFactory.getLogger(this.getClass()).warn("Erreur dans le lancement du FeedCronTrigger");			
		}    
	}
}
