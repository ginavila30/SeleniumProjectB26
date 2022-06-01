package com.cydeo.selenium_package.selenium.day3_Css_getText_getAttribute;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*TC #3: NextBaseCRM, locators, getText(), getAttribute() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In*/
public class Practice3_getAttribute_Css {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
       driver.get("https://login1.nextbasecrm.com/");
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        String actualText = loginButton.getAttribute("value");
        String expectedText = "Log In";
        System.out.println(actualText.equals(expectedText) ? "passed" : "failed");
        driver.quit();
    }
}
