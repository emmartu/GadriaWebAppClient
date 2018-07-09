package it.mountaineering.gadria.client.main;

import java.util.List;
import java.util.Timer;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import it.mountaineering.gadria.client.property.ApplicationProperties;
import it.mountaineering.gadria.client.scheduled.task.LatestPictureTakerTask;
import it.mountaineering.gadria.client.util.ClassPathFileResourceLocator;
import it.mountaineering.gadria.client.util.NetClient;
import it.mountaineering.gadria.client.util.PropertiesManager;

public class GadriaWebAppClientMain implements ServletContextListener {
	private static final java.util.logging.Logger log = Logger.getLogger(GadriaWebAppClientMain.class.getName());

	public static ServletContext servletContext;
	public static Timer pictureTakerTimer;
	public static LatestPictureTakerTask pictureTakerLauncher;
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		log.info("contextInitialized");
        servletContext = sce.getServletContext();
        ClassPathFileResourceLocator.getInstance(servletContext);
        PropertiesManager.setupConfigProperties();
        //String gadriaMonitoringUrl = servletContext.getInitParameter("gadriaMonitoringUrl");
        //ApplicationProperties.setGadriaMonitoringUrl(gadriaMonitoringUrl);
        //log.info("gadriaMonitoringUrl: "+gadriaMonitoringUrl);
        //String currentImageDir = servletContext.getInitParameter("currentImageDir");
        //ClassPathFileResourceLocator.getInstance(servletContext).getFileResource(currentImageDir);
        //ClassPathFileResourceLocator.getInstance(servletContext).getFileResourceAsStream(currentImageDir);
        
        //ApplicationProperties.setCurrentImageDir(servletContext.getInitParameter("currentImageDir"));
        //log.info("currentImageDir: "+currentImageDir);
        //setUpRemoteProperties();
        //launchPictureTakerScheduledTasks();
	}

	private void setUpRemoteProperties() {
		Long pictureInterval = NetClient.getPictureInterval();
        log.info("pictureInterval: "+pictureInterval);
		ApplicationProperties.setPictureInterval(pictureInterval);
		List<String> webcamIdList = NetClient.getWebcamIdLIst();
		ApplicationProperties.setWebcamIdList(webcamIdList);
        log.info("webcamIdList: "+webcamIdList.toString());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//pictureTakerTimer.cancel();
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
