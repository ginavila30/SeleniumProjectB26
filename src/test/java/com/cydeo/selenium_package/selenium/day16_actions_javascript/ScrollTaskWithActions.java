package com.cydeo.selenium_package.selenium.day16_actions_javascript;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method


TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
 */
public class ScrollTaskWithActions {
    @Test
    public static void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.Practice.Url"));
        WebElement powerByCydeo = Driver.getDriver().findElement(By.linkText("CYDEO"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(powerByCydeo).perform();
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
        Driver.closeDriver();

    }
}
