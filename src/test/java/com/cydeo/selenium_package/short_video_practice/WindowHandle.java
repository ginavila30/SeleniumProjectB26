package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle extends TestBase {
    @Test
    public void windowHandle(){
        driver.get("https://practice.cydeo.com/windows");
        String currentHandle = driver.getWindowHandle();
        System.out.println(currentHandle);
        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println(allWindowHandles);
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.=\"Click Here\"]"));
        clickHereBtn.click();
        currentHandle = driver.getWindowHandle();
        System.out.println(currentHandle);
        allWindowHandles=driver.getWindowHandles();
        for(String each:allWindowHandles){
            System.out.println(each);
            driver.switchTo().window(each);
            System.out.println("driver.getTitle() = " + driver.getTitle());

        }


    }
}
