package com.FBLogin.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_Reader {
	public static Properties p;
	
	public Config_Reader() throws Throwable {
	File f = new File("C:\\Users\\LINGARAJ\\eclipse-workspace\\FBcucumber\\src\\test\\java\\com\\property\\com\\config.properties");
	
	FileInputStream fis = new FileInputStream(f);
	
	p = new Properties();
	
	p.load(fis);
	}
	
	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}
	
	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}
}

