package com.cydeo.selenium_package.selenium.day5_findelements_checkbox_radiobtn;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice1_LocatingCheckBoxes {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement checkBox1= driver.findElement(By.id("box1"));
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        checkBox1.click();
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());

        WebElement checkBox2=driver.findElement(By.xpath("//input[@id='box2']"));
        System.out.println("checkBox2.getAttributes() = " + checkBox2.getAttribute("checked"));
        checkBox2.click();
        System.out.println("checkBox2.getAttributes() = " + checkBox2.getAttribute("checked"));


        if(checkBox1.isSelected()){
            System.out.println("Checkbox 1 already selected");
        }else{checkBox1.click();}

        driver.quit();
    }
}
