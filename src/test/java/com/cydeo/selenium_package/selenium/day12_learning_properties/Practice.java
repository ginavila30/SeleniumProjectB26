package com.cydeo.selenium_package.selenium.day12_learning_properties;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search


Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.

 */
public class Practice {
    @Test
    public void test(){
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("url"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        searchBox.sendKeys(ConfigurationReader.getProperty("search.word"), Keys.ENTER);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(ConfigurationReader.getProperty("search.word")));
        Driver.closeDriver();

    }
}
