package com.cydeo.test.day3_Css_getText_getAttribute;
/*1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected: Expected: first name*/

import com.cydeo.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice2_getText_getAttribute {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/registration_form");
        WebElement headerText= driver.findElement(By.tagName("h2"));
        String actualText=headerText.getText();
        String expectedText="Registration form";
        System.out.println(actualText.equals(expectedText)?"passed":"failed");
        WebElement inputBox=driver.findElement(By.className("form-control"));
        String expectedPlaceHolder="first name";
        String actualPlaceHolder=inputBox.getAttribute("placeholder");// getAttribute method, gives me the value of a given attribute
        System.out.println(actualPlaceHolder.equals(expectedPlaceHolder)?"passed":"failed");
        driver.quit();

    }
}
