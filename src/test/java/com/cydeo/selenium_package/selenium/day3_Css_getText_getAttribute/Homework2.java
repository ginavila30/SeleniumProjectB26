package com.cydeo.selenium_package.selenium.day3_Css_getText_getAttribute;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(" https://login1.nextbasecrm.com/?forgot_password=yes");
        WebElement loginBox= driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        loginBox.sendKeys("incorrect");
        WebElement resetPasswordButton= driver.findElement(By.cssSelector("button[value='Reset password']"));
        resetPasswordButton.click();
        WebElement errorMessage= driver.findElement(By.cssSelector("div.errortext"));
        String expectedText="Login or E-mail not found";
        String actualText =errorMessage.getText();
        System.out.println(actualText);
        System.out.println(actualText.equals(expectedText)?"Passed":"Failed");
    }
}
