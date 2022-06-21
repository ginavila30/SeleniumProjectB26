package com.cydeo.selenium_package.selenium.day13_reading_properties;

import com.cydeo.selenium_package.Utilities.BrowserUtils;
import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*   1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
            3. Enter valid username
4. Enter valid password
5. Click to Log In button
6. Verify title is as expected:
    Expected: Portal
}*/
public class T1_Config_Practice {
    @Test
    public void login_crm_app() {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("env"));
        WebElement userNameInput = driver.findElement(By.xpath("//input[@class=\"login-inp\"] [@name=\"USER_LOGIN\"]"));
        userNameInput.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement logInBtn = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        logInBtn.click();
        BrowserUtils.verifyTitle(driver,"Portal");
        Driver.closeDriver();
    }

}