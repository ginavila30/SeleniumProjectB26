package com.cydeo.test.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    /*
    *  TASK: NEW METHOD CREATION
// Method name : getDriver
// Static method
// Accepts String arg: browserType
//   - This arg will determine what type of browser is opened
//   - if "chrome" passed --> it will open chrome browser
//   - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"
You do not have permission to send messages in this channel.
*/

    public static WebDriver getDriver(String browserType){
        browserType=browserType.toLowerCase();
        WebDriver driver = null;
        switch (browserType){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Given browser type is not currently support");
        }

        return driver;
    }

    public static void main(String[] args) {
      getDriver("firefox").get("https://www.google.com/");
    }
}
