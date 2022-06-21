package com.cydeo.selenium_package.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*TC : Create utility method

1. Create a new class called BrowserUtils
2. Create a method to make Multiple Windows logic re-usable
3. When method is called, it should switch window and verify
title.

Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
  */
public class BrowserUtils {
//Verification of a page title
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle)," Title verification failed");
    }
//Switching to an specific window and verifying title and url is the expected one
    public static void switchWindowAndVerify(WebDriver driver, String expectedUrl,String expectedTitle){
        Set<String> windows=driver.getWindowHandles();
        for (String each:windows) {
            if(driver.switchTo().window(each).getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains(expectedTitle),expectedTitle+" Title verification failed");
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl),expectedUrl+" Url verification failed");
    }
}
