package com.cydeo.selenium_package.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static  Properties properties = new Properties();
   static {
       try {
           FileInputStream file = new FileInputStream("configuration.properties");
           properties.load(file); // loading file so we can use it
           file.close();//we can close it because we already load it
       }catch (IOException e){
           System.out.println("Error occurred while reading configuration file");
           e.printStackTrace();
       }


   }
   public static String getProperty(String key){
       return properties.getProperty(key);
   }
}
