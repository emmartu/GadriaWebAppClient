package it.mountaineering.gadria.client.property;

import java.util.List;

public class ApplicationProperties {

	private static String gadriaMonitoringUrl = "localhost:8080";
	private static String currentImageDir;
	private static Long pictureInterval = 0L;
	private static List<String> webcamIdList;

	public static String getGadriaMonitoringUrl() {
		return gadriaMonitoringUrl;
	}

	public static void setGadriaMonitoringUrl(String gadriaMonitoringUrl) {
		ApplicationProperties.gadriaMonitoringUrl = gadriaMonitoringUrl;
	}

	public static String getCurrentImageDir() {
		return currentImageDir;
	}

	public static void setCurrentImageDir(String currentImageDir) {
		ApplicationProperties.currentImageDir = currentImageDir;
	}

	public static Long getPictureInterval() {
		return pictureInterval;
	}

	public static void setPictureInterval(Long pictureInterval) {
		ApplicationProperties.pictureInterval = pictureInterval;
	}

	public static List<String> getWebcamIdList() {
		return webcamIdList;
	}

	public static void setWebcamIdList(List<String> webcamIdList) {
		ApplicationProperties.webcamIdList = webcamIdList;
	}

}
