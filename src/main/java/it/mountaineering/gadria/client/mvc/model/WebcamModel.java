package it.mountaineering.gadria.client.mvc.model;

import java.io.File;
import java.util.List;
import java.util.Map;

public class WebcamModel {

	List<String> webcamIdList;
	Map<String, File> webcamIdPictureMap;

	public List<String> getWebcamIdList() {
		return webcamIdList;
	}

	public void setWebcamIdList(List<String> webcamIdList) {
		this.webcamIdList = webcamIdList;
	}

	public Map<String, File> getWebcamIdPictureMap() {
		return webcamIdPictureMap;
	}

	public void setWebcamIdPictureMap(Map<String, File> webcamIdPictureMap) {
		this.webcamIdPictureMap = webcamIdPictureMap;
	}

}
