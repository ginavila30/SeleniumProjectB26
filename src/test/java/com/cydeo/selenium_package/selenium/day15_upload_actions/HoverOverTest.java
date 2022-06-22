package com.cydeo.selenium_package.selenium.day15_upload_actions;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*TC : Google hover over test

1. Go to  https://www.google.com
2. Hover over on Search button
3. Hover over on Feeling Lucky button  */
public class HoverOverTest {
    @Test
    public static void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        WebElement searchBtn= Driver.getDriver().findElement(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]//input[@value=\"Google Search\"]"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(searchBtn).perform();
        WebElement feelingLucky = Driver.getDriver().findElement(By.cssSelector("#gbqfbb"));
        action.moveToElement(feelingLucky).perform();

    }
}
