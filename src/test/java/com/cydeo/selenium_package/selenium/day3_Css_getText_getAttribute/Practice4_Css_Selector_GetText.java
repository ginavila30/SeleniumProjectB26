package com.cydeo.selenium_package.selenium.day3_Css_getText_getAttribute;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice4_Css_Selector_GetText {
    /*TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password

*/
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        WebElement resetPassword = driver.findElement(By.cssSelector("button.login-btn"));
        String actualText = resetPassword.getText();
        String expectedText="Reset password";
        System.out.println(actualText.equals(expectedText)?"passed":"failed");
        driver.quit();
    }
}
