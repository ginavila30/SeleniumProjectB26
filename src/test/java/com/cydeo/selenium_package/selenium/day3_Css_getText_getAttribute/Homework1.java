package com.cydeo.selenium_package.selenium.day3_Css_getText_getAttribute;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(" https://login1.nextbasecrm.com/");

        WebElement rememberMeText = driver.findElement(By.cssSelector("label.login-item-checkbox-label"));
        String expectedText="Remember me on this computer";
        String actualText=rememberMeText.getText();
        System.out.println(actualText.equals(expectedText)?"Passed":"Failed");

        WebElement forgotPasswordButton=driver.findElement(By.cssSelector("a[class='login-link-forgot-pass']"));
        expectedText="Forgot your password?";
        actualText=forgotPasswordButton.getText();
        System.out.println(actualText.equals(expectedText)?"Passed":"Failed");

        String expectedAttributeValue="forgot_password=yes";
        String actualAttributeValue= forgotPasswordButton.getAttribute("href");
        System.out.println(actualAttributeValue.contains(expectedAttributeValue)?"Passed":"Failed");

        driver.quit();




    }
}
