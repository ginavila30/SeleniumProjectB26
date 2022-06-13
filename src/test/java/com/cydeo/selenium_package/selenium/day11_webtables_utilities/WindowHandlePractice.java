package com.cydeo.selenium_package.selenium.day11_webtables_utilities;

import com.cydeo.base.TestBase;
import com.cydeo.selenium_package.Utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

/*TC #2: Window Handle practice

1. Create new test and make set ups
2. Go to : https://www.amazon.com
3. Copy paste the lines from below into your class
4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains “Etsy”

Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

These lines will simply open new tabs using something called JavascriptExecutor
and get those pages. We will learn JavascriptExecutor later as well.
  */
public class WindowHandlePractice extends TestBase {
    @Test
    public void practice1() throws InterruptedException {
        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
//        Set<String> windows = driver.getWindowHandles();
//        for (String each : windows) {
//            if (driver.switchTo().window(each).getTitle().contains("Etsy")) {
//                System.out.println("driver.getTitle() = " + driver.getTitle());
//                break;
//            }
//
//        }
//        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
// The method below is covering the above actions
        BrowserUtils.switchWindowAndVerify(driver,"https://www.etsy.com/","Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        BrowserUtils.switchWindowAndVerify(driver,"https://www.facebook.com/","Facebook - log in or sign up");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
}
