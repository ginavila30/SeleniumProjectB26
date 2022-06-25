package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitPractice {
    @Test
    public void waitTitleChanges(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading");
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),15);
        WebElement link7 = Driver.getDriver().findElement(By.partialLinkText("Example 7"));
        link7.click();
        wait.until(ExpectedConditions.titleContains("Dynamic title"));
        WebElement message = Driver.getDriver().findElement(By.cssSelector("#alert"));
        Assert.assertEquals(message.getText(),"Done!");
    }
}
