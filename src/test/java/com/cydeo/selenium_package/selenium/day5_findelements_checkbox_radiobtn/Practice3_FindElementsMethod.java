package com.cydeo.selenium_package.selenium.day5_findelements_checkbox_radiobtn;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Practice3_FindElementsMethod {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");

        List<WebElement> allColors= driver.findElements(By.name("color"));
        System.out.println("allColors.size() = " + allColors.size());

        for (WebElement each:allColors) {
            System.out.println("Current radio button is "+each.getAttribute("id"));
            System.out.println("Is it enabled: "+each.isEnabled());
            System.out.println("Is it selected: "+each.isSelected());
        }

        driver.quit();
    }
}
