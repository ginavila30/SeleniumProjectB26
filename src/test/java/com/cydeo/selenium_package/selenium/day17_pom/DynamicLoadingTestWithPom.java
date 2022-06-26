package com.cydeo.selenium_package.selenium.day17_pom;

import com.cydeo.pages.CydeoPracticeDynamicLoadingPage;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTestWithPom {
    CydeoPracticeDynamicLoadingPage obj = new CydeoPracticeDynamicLoadingPage();
/*TC#5 : Dynamically Loaded Page Elements 1
1. Go to https://practice.cydeo.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your password is invalid!” text is displayed.
Note: Follow POM Design Pattern */

    @Test
    public void test1() {
        obj.goTo();
        obj.startBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.invisibilityOf(obj.loadingBar));
        Assert.assertTrue(obj.usernameBox.isDisplayed());
        obj.usernameBox.sendKeys("tomsmith");
        obj.passwordBox.sendKeys("incorrectpassword");
        obj.signinBtn.click();
        Assert.assertTrue(obj.errorMessage.getText().contains("Your password is invalid!"));
        Driver.closeDriver();


    }
}
