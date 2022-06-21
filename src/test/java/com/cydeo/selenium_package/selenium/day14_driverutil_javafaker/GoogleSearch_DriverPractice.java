package com.cydeo.selenium_package.selenium.day14_driverutil_javafaker;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Go to "https://www.google.com/"
// Write “apple” in search box
 // Verify title:
 //Expected: apple - Google Search

*/
public class GoogleSearch_DriverPractice {
   @Test
    public static void google_search_driver_practice(){
       WebDriver driver = Driver.getDriver();
      System.out.println(((RemoteWebDriver) driver).getSessionId());
      driver.get(ConfigurationReader.getProperty("link"));
      System.out.println(((RemoteWebDriver) driver).getSessionId());
       WebElement searchBox =driver.findElement(By.name("q"));
      System.out.println(((RemoteWebDriver) driver).getSessionId());
       searchBox.sendKeys(ConfigurationReader.getProperty("search_word"), Keys.ENTER);
       String expectedTitle="\"apple\" - Google Search";
       Assert.assertEquals(driver.getTitle(),expectedTitle);
       Driver.closeDriver();
      System.out.println(((RemoteWebDriver) driver).getSessionId());
   }

}
