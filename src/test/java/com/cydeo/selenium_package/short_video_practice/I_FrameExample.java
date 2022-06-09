package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class I_FrameExample extends TestBase {
    @Test
    public void iFrame(){
        driver.get("https://practice.cydeo.com/iframe");
        //All possible options below:
//        WebElement iFrame= driver.findElement(By.id("mce_0_ifr"));
//        driver.switchTo().frame(iFrame);
//        driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");
        WebElement textArea = driver.findElement(By.xpath("//p[.=\"Your content goes here.\"] "));
        Assert.assertTrue(textArea.isDisplayed());
        driver.switchTo().parentFrame();
    }
}
