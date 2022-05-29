package com.cydeo.test.day5_findelements_checkbox_radiobtn;

import com.cydeo.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/*1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.

2
You do not have permission to send messages in this channel.
*/
public class T3_CheckBox {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id=\"box1\"]"));//input#box1 css locator
        //2. Confirm checkbox #1 is NOT selected by default
        System.out.println(checkBox1.isSelected() ? "Failed" : "Passed");
        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id=\"box2\"]"));
        System.out.println(checkBox2.isSelected() ? "Passed" : "Failed");
        //  4. Click checkbox #1 to select it.
        checkBox1.click();
        // 5. Click checkbox #2 to deselect it.
        checkBox2.click();
        // 6. Confirm checkbox #1 is SELECTED.
        System.out.println(checkBox1.isSelected() ? "Passed" : "Failed");
        // 7. Confirm checkbox #2 is NOT selected.
        System.out.println(checkBox2.isSelected() ? "Failed" : "Passed");
        driver.quit();
    }
}
