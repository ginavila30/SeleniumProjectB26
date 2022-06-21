package com.cydeo.selenium_package.selenium.day14_driverutil_javafaker;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SingletonDriverVersion {
    //    WebDriver driver;
//
//    @BeforeMethod
//    public void setUpMethod(){
//        System.out.println("Before method is running");
//        // set up chrome and create WebDriver instance
//        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        //Providing extra time for our driver before it throws NoSuchElementException
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @AfterMethod
//    public void tearDownMethod(){
//        System.out.println("After method is running");
//        driver.close();
//
//    }
    //Code above not needed any more

    @Test
    public void googleTitle(){
        Driver.getDriver().get("https://google.com");
        System.out.println("google test driver = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
    }

    @Test
    public void yahooTitle(){
        Driver.getDriver().get("https://yahoo.com");
        System.out.println("yahoo test driver = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
    }


    @Test
    public void etsyTitle(){
        Driver.getDriver().get("https://etsy.com");
        System.out.println("etsy test driver = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
    }
}
