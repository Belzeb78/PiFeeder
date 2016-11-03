package pifeeder.pifeeder.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restlet.resource.ServerResource;
import org.slf4j.LoggerFactory;

import pifeeder.pifeeder.metier.Feeder;
import pifeeder.pifeeder.webservice.dto.DtoFeeding;

@Path("/feed")
public class RestFeed extends ServerResource {

	@GET
	@Produces("text/html")
	public String getHtml() {
		return "\n" + "This is an easy resource (as html text).\n" + "";
	}

	@GET
	@Produces("text/plain")
	public String getPlain() {
		return "This is an easy resource (as plain text)";
	}
	@POST
	@Path("/process")
	@Consumes(MediaType.APPLICATION_JSON)
	public void processFeed(DtoFeeding dtoFeeding) {
		LoggerFactory.getLogger(this.getClass()).info(
				String.format("### Feeding : %d,%d,%d,%d",dtoFeeding.getNbRepetitions(),dtoFeeding.getTempsPause(),
						dtoFeeding.getAngleMinimum(),dtoFeeding.getAngleMaximum() ));
		Feeder.feed(dtoFeeding.getNbRepetitions(),dtoFeeding.getTempsPause(),dtoFeeding.getAngleMinimum(),dtoFeeding.getAngleMaximum());
	}

	public RestFeed() {
	}
}
