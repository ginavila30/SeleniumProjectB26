package com.cydeo.selenium_package.selenium.day7_testng_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/*TC #1: Verifying “Simple dropdown” and “State selection”
dropdown default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
*/
public class T1_SimpleSDropDown extends TestBase {
    @Test
    public void simpleDropDown(){
        driver.get("https://practice.cydeo.com/dropdown");
        Select selectDropDown = new Select(driver.findElement(By.xpath("//select[@id=\"dropdown\"]"))); //found element and passed it as argument for creating select obj.
        Assert.assertEquals("Please select an option",selectDropDown.getFirstSelectedOption().getText(),"Default selected value verification failed");
    }
    @Test
    public void stateSelection(){
        driver.get("https://practice.cydeo.com/dropdown");
        Select selectDropDown = new Select(driver.findElement(By.xpath("//select[@id=\"state\"]")));
        Assert.assertEquals("Select a State",selectDropDown.getFirstSelectedOption().getText(),"Default selected value verification failed");
    }
}
