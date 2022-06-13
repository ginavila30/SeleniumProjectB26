package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NestedFrames extends TestBase {
    @Test
    public void nestedFrames(){
        driver.get("https://practice.cydeo.com/nested_frames");
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrameBody = driver.findElement(By.tagName("body"));
        System.out.println("bottomFrameBody = " + bottomFrameBody.getText());
        driver.switchTo().defaultContent();

        WebElement frameTop = driver.findElement(By.xpath("//frame[@src=\"/frame_top\"]"));
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src=\"/frame_middle\"]")));
        WebElement middleContent = driver.findElement(By.xpath("//div[.=\"MIDDLE\"]"));
        System.out.println("middleContent.getText() = " + middleContent.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrameBody = driver.findElement(By.tagName("body"));
        System.out.println("rightFrameBody.getText() = " + rightFrameBody.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src=\"/frame_left\"]")));
        WebElement leftFrameBody = driver.findElement(By.tagName("body"));
        System.out.println("leftFrameBody.getText() = " + leftFrameBody.getText());


    }
}
