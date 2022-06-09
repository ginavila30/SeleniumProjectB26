package com.cydeo.selenium_package.selenium.day7_testng_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TC : Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
 Select year using   : visible text
Select month using    : value attribute Select
day using : index number   */
public class Homework extends TestBase {
    @Test
    public void selectDateAndVerify(){
        driver.get("https://practice.cydeo.com/dropdown");
//Create select object by passing web element
        Select select = new Select(driver.findElement(By.id("year")));
        select.selectByVisibleText("1923");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1923");
        select = new Select(driver.findElement(By.id("month")));
        select.selectByValue("11");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"December");
        select = new Select(driver.findElement(By.id("day")));
        select.selectByIndex(0);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1");




    }
}
