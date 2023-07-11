package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties prop;
	
	//This method is used to load the properties from config.properties file 
	// It returns the Properties prop object
	public  Properties init_prop() {
		prop = new Properties();
		
		try {
			
		FileInputStream fp = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(fp);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
