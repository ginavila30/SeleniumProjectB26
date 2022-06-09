package com.cydeo.selenium_package.selenium.day7_testng_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/*TC #2: Selecting state from State dropdown and verifying
result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index) */
public class T2_SelectDropdown extends TestBase {
    @Test
    public void selectAndVerifyStateSelect(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select select = new Select(driver.findElement(By.cssSelector("#state")));
        select.selectByValue("IL");
        select.selectByVisibleText("Virginia");
        select.selectByIndex(5);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"California"," State selection verification failed");
    }
}
