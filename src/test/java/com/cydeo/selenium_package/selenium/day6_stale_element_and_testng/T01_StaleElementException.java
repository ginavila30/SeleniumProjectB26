package com.cydeo.selenium_package.selenium.day6_stale_element_and_testng;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS  */
public class T01_StaleElementException {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/add_remove_elements/");
        WebElement addElementBtn= driver.findElement(By.xpath("//button[.=\"Add Element\"] "));
        addElementBtn.click();
        WebElement deleteBtn= driver.findElement(By.xpath("//button[@*=\"deleteElement()\"]"));
        System.out.println(deleteBtn.isDisplayed()?"Displayed":"Not Displayed");
        deleteBtn.click();
        try {
            System.out.println(deleteBtn.isDisplayed()?"Displayed":"Not Displayed");
        }catch(StaleElementReferenceException e){
          //  e.printStackTrace();

            System.out.println("A staleElementReference exception was found");
            System.out.println("Element not longer available, it is completely unavailable from the page and html");
        }finally {
            System.out.println("Testing Finally Block");
        }

        driver.quit();

    }
}
