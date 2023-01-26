package org.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	public static Properties prop;
	public static FileInputStream fis;
	/**
	 * This method will initialize the properties and read the properties file, load it
	 * @return it returns properties instance
	 */
	
	public static Properties initializeProp() {
		 prop = new Properties();
		 File f = new File(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		 try {
			  fis = new FileInputStream(f);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
