package com.cydeo.selenium_package.selenium.day10_utilities_windows;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NestedFramesPractice extends TestBase {
    @Test
    public void nestedFrames() {
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        WebElement parentFrame= driver.findElement(By.tagName("body"));
        System.out.println("parentFrame.getText() = " + parentFrame.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]")));
        WebElement childFrame = driver.findElement(By.xpath("//p[.=\"Child Iframe\"]"));
        System.out.println("childFrame.getText() = " + childFrame.getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//div[@id=\"framesWrapper\"]")).getText());

    }
}
