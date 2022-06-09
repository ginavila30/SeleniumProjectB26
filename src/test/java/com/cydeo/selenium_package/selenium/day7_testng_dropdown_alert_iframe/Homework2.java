package com.cydeo.selenium_package.selenium.day7_testng_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TC : Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up” // requirement needs to be updated.

*Remember: If there is no <select>  tag, it is called HTML
dropdown and We handle just as any other web element.
We locate. We click.  */
public class Homework2 extends TestBase {
    @Test
    public void nonSelectDropDown(){
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement selectBtn = driver.findElement(By.cssSelector("#dropdownMenuLink"));
        selectBtn.click();
        WebElement fbBtn= driver.findElement(By.xpath("//a[.=\"Facebook\"]"));
        fbBtn.click();
        Assert.assertEquals(driver.getTitle(),"Facebook - log in or sign up", "Title verification failed");

    }
}
