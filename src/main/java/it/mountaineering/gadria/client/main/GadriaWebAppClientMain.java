package it.mountaineering.gadria.client.main;

import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import it.mountaineering.gadria.client.property.ApplicationProperties;
import it.mountaineering.gadria.client.scheduled.task.LatestPictureTakerTask;
import it.mountaineering.gadria.client.util.NetClient;

public class GadriaWebAppClientMain implements ServletContextListener {

	public static ServletContext servletContext;
	public static Timer pictureTakerTimer;
	public static LatestPictureTakerTask pictureTakerLauncher;
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");
        servletContext = sce.getServletContext();
        ApplicationProperties.setGadriaMonitoringUrl(servletContext.getInitParameter("gadriaMonitoringUrl"));
        ApplicationProperties.setCurrentImageDir(servletContext.getInitParameter("currentImageDir"));
        setUpRemoteProperties();
        launchPictureTakerScheduledTasks();
	}

	private void setUpRemoteProperties() {
		Long pictureInterval = NetClient.getPictureInterval();
		ApplicationProperties.setPictureInterval(pictureInterval);
		List<String> webcamIdList = NetClient.getWebcamIdLIst();
		ApplicationProperties.setWebcamIdList(webcamIdList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		pictureTakerTimer.cancel();
	}
	
	private void launchPictureTakerScheduledTasks() {
		Long pictureInterval = 0L;
		pictureInterval = ApplicationProperties.getPictureInterval();
		
		Long millisTaskTimePeriod = 1000*pictureInterval;
		pictureTakerTimer = new Timer();
		pictureTakerLauncher = new LatestPictureTakerTask();
		pictureTakerTimer.schedule(pictureTakerLauncher, 0, millisTaskTimePeriod);
	}


}
