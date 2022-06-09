package com.cydeo.selenium_package.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dropDownNoSelectTag {
    WebDriver driver;
    @BeforeClass
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);}

    @Test
    public void dropdownWithNoSelectTag(){
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropdown =driver.findElement(By.cssSelector("#dropdownMenuLink"));
        dropdown.click();
        WebElement optionYahoo = driver.findElement(By.linkText("Yahoo"));
        optionYahoo.click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
