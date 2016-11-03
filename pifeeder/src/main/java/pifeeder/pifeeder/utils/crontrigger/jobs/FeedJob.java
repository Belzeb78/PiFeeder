package pifeeder.pifeeder.utils.crontrigger.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import pifeeder.pifeeder.metier.Feeder;
import pifeeder.pifeeder.utils.parameter.ParamManager;

public class FeedJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Feeder.feed(ParamManager.getInstance().getParameter().getNbRepetition(),
				ParamManager.getInstance().getParameter().getTempsPause(),
				ParamManager.getInstance().getParameter().getAngleDebut(),
				ParamManager.getInstance().getParameter().getAngleFin());
	}
}
