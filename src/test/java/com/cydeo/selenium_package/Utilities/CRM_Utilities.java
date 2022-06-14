package com.cydeo.selenium_package.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    public static   void login_crm(WebDriver driver){
        driver.get(ConfigurationReader.getProperty("env"));
        WebElement userNameInput = driver.findElement(By.xpath("//input[@class=\"login-inp\"] [@name=\"USER_LOGIN\"]"));
        userNameInput.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement logInBtn = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        logInBtn.click();
    }
    public static void login_crm(WebDriver driver, String username, String password){
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameInput = driver.findElement(By.xpath("//input[@class=\"login-inp\"] [@name=\"USER_LOGIN\"]"));
        userNameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys(password);
        WebElement logInBtn = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        logInBtn.click();
    }
}
