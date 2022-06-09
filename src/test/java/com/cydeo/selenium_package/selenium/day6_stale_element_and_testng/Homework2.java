package com.cydeo.selenium_package.selenium.day6_stale_element_and_testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*TC #6: StaleElementReferenceException Task

1. Open a chrome browser
2. Go to: https://practice.cydeo.com/abtest
3. Locate “CYDEO” link, verify it is displayed.
4. Refresh the page.
5. Verify it is displayed, again.  */
public class Homework2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void checkCydeoLink() {
        driver.get("https://practice.cydeo.com/abtest");
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.=\"CYDEO\"]"));
        System.out.println(cydeoLink.isDisplayed());
        driver.navigate().refresh();
        cydeoLink = driver.findElement(By.xpath("//a[.=\"CYDEO\"]"));
        System.out.println(cydeoLink.isDisplayed());
//        try {
//            cydeoLink.isDisplayed();
//        } catch (StaleElementReferenceException e) {
//            cydeoLink = driver.findElement(By.xpath("//a[.=\"CYDEO\"]"));
//            System.out.println(cydeoLink.isDisplayed());
//        }
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @AfterClass
    public void tearDownClass(){
        driver.quit();
    }
}

