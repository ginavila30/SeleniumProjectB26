package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.Utilities.WebDriverFactory;
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
        expectedText=forgotPasswordButton.getText();
        actualText="Forgot your password?";
        System.out.println(actualText.equals(expectedText)?"Passed":"Failed");

        String expectedAttributeValue="forgot_password=yes";
        String actualAttributeValue= forgotPasswordButton.getAttribute("href");
        System.out.println(actualAttributeValue.contains(expectedAttributeValue)?"Passed":"Failed");




    }
}
