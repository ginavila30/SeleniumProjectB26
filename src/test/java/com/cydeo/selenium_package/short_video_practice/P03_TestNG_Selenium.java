package com.cydeo.selenium_package.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P03_TestNG_Selenium {
    WebDriver  driver;
    @BeforeMethod
    public void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyTitle(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google","Google is not matching");
    }
}
