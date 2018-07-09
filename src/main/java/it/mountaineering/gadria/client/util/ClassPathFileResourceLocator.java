package it.mountaineering.gadria.client.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;

public class ClassPathFileResourceLocator {
	private static final java.util.logging.Logger log = Logger.getLogger(ClassPathFileResourceLocator.class.getName());

	private ServletContext servletContext;
	private static ClassPathFileResourceLocator instance;

	public static ClassPathFileResourceLocator getInstance(ServletContext servletContext){
		if(instance==null){
			instance = new ClassPathFileResourceLocator(servletContext);
		}
	
		//instance.getFileResource("latest_image");
		//instance.getFileResourceAsStream(".//");

		return instance;
	}

	public static ClassPathFileResourceLocator getInstance(){
		return instance;
	}

	private ClassPathFileResourceLocator(ServletContext servletContext){
		this.servletContext = servletContext;
	}
	
	public File getFileResource(String fileName){
		log.info("getFileResource fileName: "+fileName);

		String path = null;
		
	    path = servletContext.getRealPath(fileName);
		log.info("getFileResource url: "+path);

		File file = new File(path);

		return file;
	}
	
	public List<String> readFile(String fileName) throws Exception {
		List<String> result = new ArrayList<String>();
		File file = getFileResource(fileName);
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		while((line = bufferedReader.readLine()) != null) {
			result.add(line);
		}
		bufferedReader.close();
		return result;
	}
	
}
