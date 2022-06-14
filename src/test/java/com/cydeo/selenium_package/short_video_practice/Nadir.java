package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Nadir extends TestBase {
    @Test
    public void interviewQ() throws InterruptedException {
        driver.get("http://te.dev.secureci.com/Exercise1.html");
        List<WebElement> links = driver.findElements(By.xpath("//area[@shape=\"rect\"]"));
        System.out.println(links);
        String expectedTitle = "You clicked on map link ";

        System.out.println(links.size());
        for (WebElement each:links) {
            try{
                each.click();
                String title = driver.findElement(By.xpath("//h1[@align=\"center\"]")).getText();
                Assert.assertTrue(title.contains(expectedTitle));
            }catch(Exception e){
                System.out.println(each+"->Link does not work");
            }
            driver.navigate().back();
        }

    }


}
