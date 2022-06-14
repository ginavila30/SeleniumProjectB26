package com.cydeo.selenium_package.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}//no instantiation allowed
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){

            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();

                    break;
                default:
                    System.out.println("Unknown Browser Type " + browserType);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //trigger when the driver cant find an element. It  gives extra time to do it.if time passes, and it does not find it; it will return exception or empty list.
            return driver;
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver !=null){
            driver.quit();//This terminates the session
            driver= null;// reset driver value to null so It can always use only one and the same instance of the object.
        }
    }
}
