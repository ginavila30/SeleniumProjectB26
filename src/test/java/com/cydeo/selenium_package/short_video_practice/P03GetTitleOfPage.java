package com.cydeo.selenium_package.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03GetTitleOfPage {
    public static void main(String[] args) {
        //set up chrome and create web driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://cydeo.com"); // navigate to google

        String title= driver.getTitle();
        System.out.println("Title of the page: "+title);

        if(title.equals("Cydeo")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }

        driver.quit();


    }
}
