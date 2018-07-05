package it.mountaineering.gadria.client.mvc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import it.mountaineering.gadria.ring.memory.bean.WebcamProperty;

public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {
		String output = "";
		String jsonInString = "";
		StringBuffer response = new StringBuffer();

		try {

			URL url = new URL("http://localhost:8001/GadriaMonitoring/enabled/webcams");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				response.append(output);
				System.out.println(output);
			}

			jsonInString = response.toString();
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		ObjectMapper mapper = new ObjectMapper();
		Map<String, WebcamProperty> mapResult = null;

		//JSON from file to Object
		try {
			mapResult = mapper.readValue(jsonInString, new TypeReference<Map<String, WebcamProperty>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String key : mapResult.keySet()) {
			System.out.println("key: "+key+" -- val = "+mapResult.get(key));
		}
	}

}