package com.cydeo.test.day5_findelements_checkbox_radiobtn;

import com.cydeo.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice2_LocatingRadioButton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.cssSelector("input#blue"));
        System.out.println("Before selected blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        blueRadioButton.click();
        System.out.println("After selected blueRadioButton.isSelected() = " + blueRadioButton.isSelected());

        WebElement redRadioButton = driver.findElement(By.cssSelector("input[id='red']"));
        System.out.println("Before clicking redRadioButton.isSelected() = " + redRadioButton.isSelected());
        redRadioButton.click();
        System.out.println("After clicking redRadioButton.isSelected() = " + redRadioButton.isSelected());
        System.out.println("After selecting red is blueRadioButton.isSelected()? = " + blueRadioButton.isSelected());

        WebElement greenRadioButton = driver.findElement(By.id("green"));
        greenRadioButton.click();
        System.out.println("greenRadioButton.isSelected() = " + greenRadioButton.isSelected());
        greenRadioButton.isEnabled();

        driver.quit();
    }


}
