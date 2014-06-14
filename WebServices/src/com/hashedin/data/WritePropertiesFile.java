package com.hashedin.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			properties.setProperty("host", "ec2-54-80-107-33.compute-1.amazonaws.com");
				properties.setProperty("port", "9275");
				properties.setProperty("protocol", "http");

			File file = new File("config.properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Config");
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}