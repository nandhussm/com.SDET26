package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Nandhu
 *
 */
public class FileUtility {
      public String getPropertyKeyValue(String key) throws IOException {
    	  FileInputStream fis = new FileInputStream("./Commondatttaaa.Properties");
    	  Properties pobj = new Properties();
    	  pobj.load(fis);
    	  String value = pobj.getProperty(key);
    	  return value;
      }
}
