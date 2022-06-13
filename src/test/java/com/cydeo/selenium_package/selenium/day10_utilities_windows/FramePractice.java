package com.cydeo.selenium_package.selenium.day10_utilities_windows;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramePractice extends TestBase {
    @Test
    public void framePractice1(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        WebElement frame1= driver.findElement(By.cssSelector("#sampleHeading"));
        Assert.assertEquals(frame1.getText(),"This is a sample page");
        Assert.assertTrue(frame1.isDisplayed());

    }
    @Test
    public void framePractice2(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        WebElement frame1= driver.findElement(By.cssSelector("#sampleHeading"));
        Assert.assertEquals(frame1.getText(),"This is a sample page");
        Assert.assertTrue(frame1.isDisplayed());

    }
}
