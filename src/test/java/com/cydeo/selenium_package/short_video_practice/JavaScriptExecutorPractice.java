package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorPractice {
    @Test(priority = 2)
    public void scrollingTest() {
        Driver.getDriver().get("https://practice.cydeo.com/large");
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.=\"Home\"]"));
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[.=\"CYDEO\"]"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)", homeLink);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
        Driver.closeDriver();
    }

    @Test(priority = 1)

    public void infiniteScroll() throws InterruptedException {
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        Thread.sleep(3000);
        JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,100)");
        }

    }

    @Test
    public void scrollIntoView() {
    }
}
