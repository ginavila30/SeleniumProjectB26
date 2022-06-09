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

public class LocatingDropdownList {
    WebDriver driver;
    @BeforeClass
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);}

    @Test
    public void verifyDropdpwnOptions() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropDown= driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
        //Create select Object
        Select selectObj= new Select(dropDown);
        //selectObj methods
        selectObj.selectByIndex(2);
        selectObj.selectByValue("2");
        //selectObj.deselectByValue("2"); we can only use it when it is multi select
        Thread.sleep(3000);
        selectObj.selectByVisibleText("Option 2");
        //Verify determined option is selected
        String expectedOption="Option 2";
        String actualOption= selectObj.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption);}

    @AfterClass
    public void teardown(){
        driver.quit();
    }



}
