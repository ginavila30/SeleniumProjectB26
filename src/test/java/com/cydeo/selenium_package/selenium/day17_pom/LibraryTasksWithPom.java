package com.cydeo.selenium_package.selenium.day17_pom;

import com.cydeo.pages.LibraryTasks2Page;
import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryTasksWithPom {
    LibraryTasks2Page obj = new LibraryTasks2Page();

    /*TC #1: Required field error message test
    1- Open a chrome browser
    2- Go to: https://library1.cydeo.com
    3- Do not enter any information
    4- Click to “Sign in” button
    5- Verify expected error is displayed:
    Expected: This field is required.

    NOTE: FOLLOW POM DESIGN PATTERN
     */
    @Test
    public void task01() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url2"));
        obj.signinBtn.click();
        Assert.assertEquals(obj.errorMsg.getText(), "This field is required.");
    }
    /*TC #2: Invalid email format error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Enter invalid email format
4- Verify expected error is displayed:
Expected: Please enter a valid email address.

NOTE: FOLLOW POM DESIGN PATTERN*/

    @Test
    public void task02() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url2"));
        obj.emailInput.sendKeys("libraryuser@.com" + Keys.ENTER);
        Assert.assertEquals(obj.errorMsg.getText(), "Please enter a valid email address.");
    }

    /*TC #3: Library negative login
    1- Open a chrome browser
    2- Go to: https://library1.cydeo.com
    3- Enter incorrect username or incorrect password
    4- Verify title expected error is displayed:
    Expected: Sorry, Wrong Email or Password

    NOTE: FOLLOW POM DESIGN PATTERN
     */
    @Test
    public void task03() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url2"));
        obj.emailInput.sendKeys("libraryuser@gmail.com");
        obj.passwordInput.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
        obj.signinBtn.click();
        Assert.assertTrue(obj.errorMsg.isDisplayed());
        Driver.closeDriver();
    }


}
