package it.mountaineering.gadria.client.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import it.mountaineering.gadria.client.property.ApplicationProperties;
import it.mountaineering.gadria.ring.memory.bean.WebcamProperty;

public class NetClient {

	private static final String _PROTOCOL = "http://";
	private static final String _HOST = ApplicationProperties.getGadriaMonitoringUrl();// "localhost:8001";
	private static final String _REST_URL = _PROTOCOL + _HOST + "/GadriaMonitoring";
	private static final String _REST_ENABLED_WEBCAMS_URL = _REST_URL + "/enabled/webcams";
	private static final String _REST_LATEST_IMAGE_URL = _REST_URL + "/latest-image/";
	private static final String _REST_WEBCAMID_LIST_URL = _REST_URL + "/webcamIdList";
	private static final String _REST_PICTURE_INTERVAL_URL = _REST_URL + "/pictureInterval";

	public static String getRestFull(String restFullUrl) {
		String output = "";
		String jsonInString = "";
		StringBuffer response = new StringBuffer();

		try {
			URL url = new URL(restFullUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			while ((output = br.readLine()) != null) {
				response.append(output);
			}

			jsonInString = response.toString();
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonInString;
	}

	public static Long getPictureInterval() {
		String restString = getRestFull(_REST_PICTURE_INTERVAL_URL);

		Long pictureInterval = Long.parseLong(restString);

		return pictureInterval;
	}

	public static List<String> getWebcamIdLIst() {
		String jsonInString = getRestFull(_REST_WEBCAMID_LIST_URL);

		ObjectMapper mapper = new ObjectMapper();
		List<String> listResult = null;

		// JSON from file to Object
		try {
			listResult = mapper.readValue(jsonInString, new TypeReference<List<String>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
			listResult = new ArrayList<String>();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			listResult = new ArrayList<String>();
		} catch (IOException e) {
			e.printStackTrace();
			listResult = new ArrayList<String>();
		}

		return listResult;
	}

	public static Map<String, WebcamProperty> getWebcamProperties() {
		String jsonInString = getRestFull(_REST_ENABLED_WEBCAMS_URL);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, WebcamProperty> mapResult = null;

		// JSON from file to Object
		try {
			mapResult = mapper.readValue(jsonInString, new TypeReference<Map<String, WebcamProperty>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
			mapResult = new HashMap<String, WebcamProperty>();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			mapResult = new HashMap<String, WebcamProperty>();
		} catch (IOException e) {
			e.printStackTrace();
			mapResult = new HashMap<String, WebcamProperty>();
		}

		return mapResult;
	}

	public static boolean getLatestImageById(String webcamId) {
		String imageUrl = _REST_LATEST_IMAGE_URL + webcamId;
		String pictureAbsoluteStorageFolder = ApplicationProperties.getCurrentImageDir();


		String relativeStorageFolder = webcamId;
		pictureAbsoluteStorageFolder = checkSlashesOnPath(pictureAbsoluteStorageFolder);
		relativeStorageFolder = checkSlashesOnPath(relativeStorageFolder);
		String fileName = "latest_" + webcamId + "_image.jpg";

		String storageFolderFullPath = pictureAbsoluteStorageFolder + relativeStorageFolder;
		checkFolder(storageFolderFullPath);

		String storageFileFullPath = pictureAbsoluteStorageFolder + relativeStorageFolder + fileName;

		try {
			saveImage(imageUrl, storageFileFullPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return true;
	}

	private static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

	private static String checkSlashesOnPath(String folderPath) {
		if (!folderPath.endsWith("\\")) {
			folderPath += "\\";
		}

		return folderPath;
	}

	private static void checkFolder(String storageFolderFullPath) {
		File directory = new File(storageFolderFullPath);
		if (!directory.exists() || !directory.isDirectory()) {
			directory.mkdir();
		}
	}

}