package com.cydeo.selenium_package.selenium.day7_testng_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*TC #3: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown 3.
Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.  */
public class T3_MultipleSelectDropDown extends TestBase {
    @Test
    public void multipleSelectDropDown() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");
        Select select = new Select(driver.findElement(By.xpath("//select[@name=\"Languages\"]")));
        Assert.assertTrue(select.isMultiple());
        //commented below the different ways to select by 3 different ways. one element at a time.
//        select.selectByIndex(0);
//        select.selectByValue("js");
//        select.selectByVisibleText("C#");
//        select.selectByIndex(3);
//        select.selectByValue("ruby");
//        select.selectByVisibleText("C");
        List<WebElement> allSelected = select.getOptions();
//        for (WebElement each:allSelected) {
//            System.out.println(each.getText());
//        }
        allSelected.forEach(each -> {System.out.println(each.getText());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            each.click();});
        Assert.assertTrue(allSelected.size() > 1);
        Thread.sleep(3000);
        select.deselectAll();
        allSelected = select.getAllSelectedOptions();
        System.out.println(allSelected);
        Assert.assertTrue(allSelected.size() == 0);
    }
}
