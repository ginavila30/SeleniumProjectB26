package com.cydeo.selenium_package.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultipleOptDropdown {

    WebDriver driver;
    @BeforeClass
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);}

    @Test
    public void multipleDropown() {
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement multiItemDropdown = driver.findElement(By.name("Languages"));
        Select select= new Select(multiItemDropdown);
        Assert.assertTrue(select.isMultiple());
        select.selectByIndex(0);
        select.selectByValue("ruby");
        select.selectByVisibleText("Python");
        Assert.assertTrue(select.getAllSelectedOptions().size()>1);
        select.deselectByIndex(0);
        select.deselectByValue("ruby");
//        select.deselectByVisibleText("Python");
      select.deselectAll();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
