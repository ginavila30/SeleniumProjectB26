package com.cydeo.selenium_package.selenium.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        // 1- Setting up web driver manager-> chrome driver.
       WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\majid\\OneDrive\\Desktop\\chromedriver.exe");
        // 2- Create instance of the chrome driver
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");
    }
}


