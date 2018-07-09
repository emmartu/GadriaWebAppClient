package it.mountaineering.gadria.client.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesManager {

	private static final java.util.logging.Logger log = Logger.getLogger(PropertiesManager.class.getName());

	private static final String _INSTALLATION_PROPERTIES = "/installation.properties";
	private static final String _INSTALLATION_PROPERTIES_FOLDER = "./WEB-INF/installation";
	private static final String _INSTALLATION_PROPERTIES_FILE = _INSTALLATION_PROPERTIES_FOLDER
			+ _INSTALLATION_PROPERTIES;
	private static final String _SERVER_INSTALLATION_HOST = "server.installation.host";
	private static final String _CLIENT_IMAGE_PATH = "client.image.path";

	protected static Map<String, String> propertiesMap = new HashMap<String, String>();
	private static Properties prop = new Properties();
	private static InputStream input = null;
	private static String serverInstallationHost = "";
	private static String clientImagePath = "";

	private static void setInstallationPropertiesFilePath() {
		try {

			File installationPropertiesFile = ClassPathFileResourceLocator.getInstance()
					.getFileResource(_INSTALLATION_PROPERTIES_FILE);
			input = new FileInputStream(installationPropertiesFile);
			prop.clear();
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void setInstallationPropertiesFilePath(File installationPropertiesFile) {
		try {
			input = new FileInputStream(installationPropertiesFile);
			prop.clear();
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getServerInstallationHost() {
		return serverInstallationHost;
	}

	public static void setServerInstallationHost(String serverInstallationHost) {
		PropertiesManager.serverInstallationHost = serverInstallationHost;
	}

	public static String getClientImagePath() {
		return clientImagePath;
	}

	public static void setClientImagePath(String clientImagePath) {
		PropertiesManager.clientImagePath = clientImagePath;
	}

	public static void setupConfigProperties() {
		log.info("**** Get Properties From config.properties ****");

		setInstallationPropertiesFilePath();

		String serverInstallationHost = getServerInstallationHostFromConfigProperties();
		log.info("ServerInstallationHost: " + serverInstallationHost);
		propertiesMap.put(_SERVER_INSTALLATION_HOST, serverInstallationHost);

		String clientImagePath = getClientImagePathFromConfigProperties();
		log.info("ClientImagePath: " + clientImagePath);
		propertiesMap.put(_CLIENT_IMAGE_PATH, clientImagePath);

		log.info("********* Properties setup Complete ***********");
	}

	private static String getStringPropertyByName(String propertyName) {
		String propertyStr = "";
		propertyStr = prop.getProperty(propertyName);

		if (propertyStr == null || propertyStr.equalsIgnoreCase("")) {
			log.severe("Cannot Read Property " + propertyName);
		}

		return propertyStr;
	}

	private static String getServerInstallationHostFromConfigProperties() {
		String serverInstallationPath = "";

		serverInstallationPath = getStringPropertyByName(_SERVER_INSTALLATION_HOST);

		if (serverInstallationPath != null && serverInstallationPath != "") {
			isIPOnline(serverInstallationPath);
		}

		return serverInstallationPath;
	}

	protected static String getClientImagePathFromConfigProperties() {
		String clientImagePath = "";

		clientImagePath = getStringPropertyByName(_CLIENT_IMAGE_PATH);

		File storageDirectory = new File(clientImagePath);

		if (!storageDirectory.exists() || !storageDirectory.isDirectory()) {
			log.severe("Client Image Folder Path property cannot access Directory");
		}

		return clientImagePath;
	}

	private static boolean isIPOnline(String webcamIP) {

		if (PingIp.isPingReachable(webcamIP)) {
			return true;
		}

		return false;
	}

}