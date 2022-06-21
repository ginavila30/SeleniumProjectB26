package com.cydeo.selenium_package.selenium.day13_reading_properties;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_file() throws IOException {
        FileInputStream file = new FileInputStream("configuration.properties");//To create object I must pass the path of the file that I want to use. right-click on the desired file, path, path from content and paste it in the argument
        Properties properties= new Properties();//need to create a Properties' obj so that later we can use method getProperty()
        properties.load(file);//the file passes is FileInputStream created in line12
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));//-> This method will be the one use to get the values paired with the key passed.
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

        //Exceptions note-> FileInputStream throws exception FileNotFoundException which is part of IO Exception
        //                  load() throws exception IO Exception
        //                  To handle them add to method signature ->throws IOException
    }


}
