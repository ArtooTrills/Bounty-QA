package org.cleartrip.utils;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * @author Hemanth.Sridhar
 */
public class SearchData {

	public static String propertiesReader(String Filepath, String key) throws IOException{		
		FileReader reader = new FileReader(Filepath);
		Properties properties = new Properties();
		properties.load(reader);
		String s = properties.getProperty(key);
		return s;	
	}
}
