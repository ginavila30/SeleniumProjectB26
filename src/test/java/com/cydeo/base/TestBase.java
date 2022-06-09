package com.cydeo.base;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        // WebDriverManager.chromedriver().setup();
        //        driver = new ChromeDriver();
        //        driver.manage().window().maximize();
        //        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
