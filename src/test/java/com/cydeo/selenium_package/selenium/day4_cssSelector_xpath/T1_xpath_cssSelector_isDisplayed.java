package com.cydeo.selenium_package.selenium.day4_cssSelector_xpath;
/*1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.*/

import com.cydeo.selenium_package.Utilities.Methods;
import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_isDisplayed {
    public static void main(String[] args) {
        //Using cssSelector
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement homeLink= driver.findElement(By.cssSelector("a[href='/']"));//a.nav-link

        System.out.println(homeLink.isDisplayed());

        WebElement forgotPasswordHeader= driver.findElement(By.cssSelector("div[class='example']>h2")); //div.example>h2
        System.out.println(forgotPasswordHeader.isDisplayed());

        WebElement emailText= driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println(emailText.isDisplayed());

        WebElement emailInputBox= driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println(emailInputBox.isDisplayed());

        WebElement retrievePasswordButton= driver.findElement(By.cssSelector("button[id='form_submit']"));//button.radius or button#form_submit
        System.out.println(retrievePasswordButton.isDisplayed());

        WebElement powerByCydeoText= driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        System.out.println(powerByCydeoText.isDisplayed());

        //Using Xpath
        WebElement homeLink2= driver.findElement(By.xpath("//a[@class='nav-link']"));////a[@href='/'] or //a[.='Home']
        System.out.println(homeLink2.isDisplayed());

        WebElement forgotPasswordHeader2= driver.findElement(By.xpath("//div[@class='example']//h2"));////h2[.='Forgot Password']
        System.out.println(forgotPasswordHeader2.isDisplayed());

        WebElement emailText2= driver.findElement(By.xpath("//label[@for='email']")); ////label[.='E-mail']
        System.out.println(emailText2.isDisplayed());

        WebElement emailInputBox2= driver.findElement(By.xpath("//input[@type='text']"));////input[@name='email'] or //input[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$']
        System.out.println(emailInputBox2.isDisplayed());

        WebElement retrievePasswordButton2= driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")); ////button[@class='radius'] or //button[@type='submit']
        System.out.println(retrievePasswordButton2.isDisplayed());

        WebElement powerByCydeoText2= driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println(powerByCydeoText2.isDisplayed());

        System.out.println(Methods.multipleElementsDisplayed(homeLink, forgotPasswordHeader, emailText, emailInputBox, retrievePasswordButton, powerByCydeoText));

        System.out.println(Methods.multipleElementsDisplayed(homeLink2, forgotPasswordHeader2, emailText2, emailInputBox2, retrievePasswordButton2, powerByCydeoText2));

        driver.quit();


    }

}
