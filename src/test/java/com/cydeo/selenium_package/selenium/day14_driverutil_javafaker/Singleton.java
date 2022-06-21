package com.cydeo.selenium_package.selenium.day14_driverutil_javafaker;

public class Singleton {
    private Singleton(){}

    private static  String word = null;

    public static String getWord(){
        if(word==null){
            System.out.println("First time calling.Word object is null");
            word="Something";
        }else{
            System.out.println("Word already assigned and has a value");
        }
        return word;
    }
}
