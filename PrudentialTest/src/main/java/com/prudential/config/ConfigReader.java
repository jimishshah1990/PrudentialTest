package com.prudential.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop=new Properties();
	
	public ConfigReader() throws IOException {
		// TODO Auto-generated constructor stub
	InputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\prudential\\config\\config.properties"));
	prop.load(fis);
	fis.close();
	
	}
	
	
	public String getPropertyValue(String key)
	{
		return prop.getProperty(key);
	}

}
