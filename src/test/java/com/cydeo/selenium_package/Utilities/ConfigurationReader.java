package com.cydeo.selenium_package.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static  Properties properties = new Properties();
   static {
       try {
           FileInputStream file = new FileInputStream("configuration.properties");// accepts the path, you can get it
           // by right click on the .priotities file and path from content root. FileInputStream designed to throw
           // IO exception
           properties.load(file); // loading file so we can use it, designe dto throw IO exception
           file.close();//we can close it because we already load it,  is designed to throw IO exception,
           // that is why I should put it inside the try block
           //IO Exception, checked exception
       }catch (IOException e){
           System.out.println("Error occurred while reading configuration file");
           e.printStackTrace();
       }


   }
   public static String getProperty(String key){
       return properties.getProperty(key);
   }// getProperty returns a String of the value linked to the key
}
