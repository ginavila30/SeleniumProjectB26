package com.cydeo.selenium_package.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static  Properties properties = new Properties();// not accessible out of the class directly, but the method get.properties() accessible outside by the public static method getProperty() created in line 21
   static { //Everytime configurationReader will be loaded or called this static block will run first thing one time. So file will be loaded in to properties right away and later with a public getter method( ) line 21 I can gerProperty(key);
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
