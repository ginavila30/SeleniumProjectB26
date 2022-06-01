package com.cydeo.selenium_package.selenium.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02_Cydeo_Url_Verification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(" https://practice.cydeo.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="cydeo";
         if(actualUrl.contains(expectedUrl)){
             System.out.println("URL Verification passed");
         }else {
             System.out.println("URL verification failed");
         }

        String actualTitle= driver.getTitle();
        String expectedTitle="Practice";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title Verification passed");
        }else {
            System.out.println("Title verification failed");
        }
        driver.quit();
    }
}
