package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertExample extends TestBase {
    @Test
    public void alertTest(){
        driver.get("https://practice.cydeo.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.=\"Click for JS Alert\"]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement resultText= driver.findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed());
    }
}
