package it.mountaineering.gadria.client.scheduled.task;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Logger;

import it.mountaineering.gadria.client.property.ApplicationProperties;
import it.mountaineering.gadria.client.util.NetClient;


public class LatestPictureTakerTask extends TimerTask {

	private static final java.util.logging.Logger log = Logger.getLogger(LatestPictureTakerTask.class.getName());
		
	Date now;
	private boolean hasStarted = false;
	
	public void run() {
		log.info("Current Picture Taker Task start! Date: "+now);

		List<String> enabledWebcamIdList = ApplicationProperties.getWebcamIdList();

		for (String webcamId : enabledWebcamIdList){
			
			NetClient.getLatestImageById(webcamId);
		}
	}

}