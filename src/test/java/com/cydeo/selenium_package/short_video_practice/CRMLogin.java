package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

 public class CRMLogin {
    @Test
    public void login_crm() {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("env"));
        WebElement userNameInput = driver.findElement(By.xpath("//input[@class=\"login-inp\"] [@name=\"USER_LOGIN\"]"));
        userNameInput.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement logInBtn = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        logInBtn.click();
        Driver.closeDriver();
    }
}
