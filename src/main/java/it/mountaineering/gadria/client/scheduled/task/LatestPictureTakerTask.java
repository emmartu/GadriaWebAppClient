package it.mountaineering.gadria.client.scheduled.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Logger;

import it.mountaineering.gadria.client.property.ApplicationProperties;
import it.mountaineering.gadria.client.util.NetClient;
import it.mountaineering.gadria.ring.memory.bean.FileWithCreationTime;
import it.mountaineering.gadria.ring.memory.bean.WebcamProperty;
import it.mountaineering.gadria.ring.memory.util.DiskSpaceManager;
import it.mountaineering.gadria.ring.memory.util.PropertiesManager;


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