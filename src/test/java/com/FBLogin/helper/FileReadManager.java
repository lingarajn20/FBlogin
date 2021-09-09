package com.FBLogin.helper;

public class FileReadManager {
	
	private FileReadManager() {
		
	}
	
	public static FileReadManager getInstanceFR() {
		FileReadManager helper = new FileReadManager();
		return helper;
	}
	
	public Config_Reader getInstanceCR() throws Throwable {
		Config_Reader reader = new Config_Reader();
		return reader;
	}
}
