package com.cydeo.test.day4_cssSelector_xpath;

import com.cydeo.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*TC #3: Practice Cydeo/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cydeo.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”  */
public class Homework {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cydeo.com/forgot_password");
        WebElement emailInputBox= driver.findElement(By.xpath("//input[@name='email']")); //CSS option input -> [name='email']
        emailInputBox.sendKeys("ginavila30@hotmail.com");
        WebElement retrievePasswordBtn= driver.findElement(By.cssSelector("button#form_submit"));//xpath option -> //button[@id='form_submit']
        retrievePasswordBtn.click();
        String actualUrl =driver.getCurrentUrl();
        String expectedUrl="email_sent";

        System.out.println(actualUrl.contains(expectedUrl)?"Passed":"Failed");

        String actualText= driver.findElement(By.xpath("//h4[@name='confirmation_message']")).getText();
        String expectedText="Your e-mail's been sent!";

        System.out.println(actualText.equals(expectedText)?"Passed":"Failed");

        driver.quit();

    }
}
