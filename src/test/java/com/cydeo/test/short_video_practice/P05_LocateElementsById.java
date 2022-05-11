package com.cydeo.test.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P05_LocateElementsById {
    public static void main(String[] args) {
        //Set up web driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //Maximize
        driver.manage().window().maximize();
        //Navigate to Google
        driver.get("https://www.google.com/");
        //Identify Im feeling lucky element and save the element
        WebElement luckyText=driver.findElement(By.id("gbqfbb"));
        //Find value of attribute
        String text=luckyText.getAttribute("value");
        //Verify if value is "I'm Feeling Lucky"

        if(text.equals("I'm Feeling Lucky")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
