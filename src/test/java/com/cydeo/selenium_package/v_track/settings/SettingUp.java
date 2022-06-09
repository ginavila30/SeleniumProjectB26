package com.cydeo.selenium_package.v_track.settings;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SettingUp {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://qa2.vytrack.com/user/login");
        WebElement usernameBox= driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("user36");
        WebElement passwordBox= driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        WebElement logInButton= driver.findElement(By.id("_submit"));
        logInButton.click();

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

