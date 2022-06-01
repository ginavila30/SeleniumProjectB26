package com.cydeo.selenium_package.selenium.day3_Css_getText_getAttribute;

import com.cydeo.selenium_package.Utilities.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
*/
public class Practice1 {
    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

       Test.driver.get("https://login1.nextbasecrm.com/");
        WebElement username = Test.driver.findElement(By.className("login-inp"));
        username.sendKeys("incorrect");
        WebElement password = Test.driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");
        WebElement loginButton = Test.driver.findElement(By.className("login-btn"));
        loginButton.click();

        String expectedErrorMessage="Incorrect login or password";
        String actualErrorMessage=Test.driver.findElement(By.className("errortext")).getText();

        System.out.println(actualErrorMessage.equals(expectedErrorMessage)?"passed":"failed");

        Test.driver.quit();
    }
}
