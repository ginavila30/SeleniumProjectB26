package com.cydeo.selenium_package.selenium.day10_utilities_windows;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowPractice  extends TestBase {
    @Test
    public void practice1(){
        driver.get("https://demoqa.com/browser-windows");
        String firstTab= driver.getWindowHandle();
        WebElement button1=driver.findElement(By.cssSelector("#tabButton"));
        button1.click();
       Set<String> windows= driver.getWindowHandles();
        for (String each:windows) {
            if(!each.equals(firstTab)){
                driver.switchTo().window(each);
            }
        }

        WebElement header1=driver.findElement(By.id("sampleHeading"));
        Assert.assertEquals(header1.getText(),"This is a sample page");
        driver.switchTo().window(firstTab);
        System.out.println(driver.getTitle());

    }
    @Test
    public void practice2(){
        driver.get("https://demoqa.com/browser-windows");
        String firstTab= driver.getWindowHandle();
        WebElement button1=driver.findElement(By.id("windowButton"));
        button1.click();
        Set<String> windows= driver.getWindowHandles();
        for (String each:windows) {
            if(!each.equals(firstTab)){
                driver.switchTo().window(each);
                System.out.println(driver.getTitle());
                WebElement header1=driver.findElement(By.id("sampleHeading"));
                Assert.assertEquals(header1.getText(),"This is a sample page");
                driver.close();
            }
        }
        driver.switchTo().window(firstTab);
        System.out.println(driver.getTitle());

    }
    @Test
    public void practice3(){
        driver.get("https://demoqa.com/browser-windows");
        String firstTab= driver.getWindowHandle();
        WebElement button1=driver.findElement(By.id("messageWindowButton"));
        button1.click();
        Set<String> windows= driver.getWindowHandles();
        for (String each:windows) {
            if(!each.equals(firstTab)){
                driver.switchTo().window(each);
                System.out.println(driver.getTitle());
                WebElement text=driver.findElement(By.xpath("//body[.=\"Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.\"]"));
                Assert.assertEquals(text.getText(),"Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
                driver.close();
            }
        }
        driver.switchTo().window(firstTab);
        System.out.println(driver.getTitle());

    }
}
