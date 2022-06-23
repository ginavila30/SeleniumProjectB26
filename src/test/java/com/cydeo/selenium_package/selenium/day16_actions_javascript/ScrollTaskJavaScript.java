package com.cydeo.selenium_package.selenium.day16_actions_javascript;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TC : Etsy Scroll down test
1. Go to https://www.etsy.com
2. Scroll down
3. Generate random email and enter into subscribe box
4. Click on Subscribe
5. Verify "Great! We've sent you an email to confirm
your subscription." is displayed */
public class ScrollTaskJavaScript {
    @Test
    public static void test1(){
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
        JavascriptExecutor jse =(JavascriptExecutor)Driver.getDriver();
        WebElement subscribeBtn= Driver.getDriver().findElement(By.xpath("//button[contains(.,\"Subscribe\")]"));
        //jse.executeScript("window.scrollBy(0,5600)");
        jse.executeScript("arguments[0].scrollIntoView(true)",subscribeBtn);
        WebElement emailInput=Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        Faker fake = new Faker();
        emailInput.sendKeys(fake.internet().emailAddress());
        subscribeBtn.click();
        WebElement confirmMessage= Driver.getDriver().findElement(By.xpath("//div[contains(.,\" Great! We've sent\")][@role=\"alert\"]"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(confirmMessage));
        Assert.assertTrue(confirmMessage.isDisplayed());
        Driver.closeDriver();
    }
    /*TC #6: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a.  750 pixels down 10 times.
b.  750 pixels up 10 times

JavaScript method to use : window.scrollBy(0,0) */
    @Test
    public static  void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        for (int i = 0; i <10 ; i++) {
            ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,750)");
        }
        for (int i = 0; i <10 ; i++) {
            ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,-750)");
        }
        Driver.closeDriver();
    }
    /*
    * TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only

JavaScript method to use : arguments[0].scrollIntoView(true) */
    @Test
    public static void  test3() throws InterruptedException {
        Driver.getDriver().get("https://practice.cydeo.com/large");
        WebElement cydeo =Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement home = Driver.getDriver().findElement(By.linkText("Home"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true)",cydeo);
        jse.executeScript("arguments[0].scrollIntoView(true)",home);
        Driver.closeDriver();
    }
}
