package com.hashedin.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertiesFile {
	private String host;
	private int port;
	private String protocol;
	
	
	public String getHost() {
		return host;
	}

	public int getPort() {

		return port;
		
	}
	
	public String getProtocol(){
		
		return protocol;
	}
	
	
	
	public void loadConfig() 
	{
		try {
			File file = new File("config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			/*Enumeration enuKeys = properties.keys();
			
			     while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);
			}*/
			
			
			host = properties.getProperty("host");
			port = Integer.parseInt(properties.getProperty("port"));
			protocol = properties.getProperty("protocol");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}