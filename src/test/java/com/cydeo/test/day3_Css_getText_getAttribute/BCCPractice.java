package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BCCPractice {
    public static void main(String[] args) {
        WebDriver driver =WebDriverFactory.getDriver("chrome");
        driver.get("https://www.bbc.com/");
       WebElement homeBotton =driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//li[@class='orb-nav-homedotcom']//a[@href='https://www.bbc.com/']//span[.='Home']"));
        homeBotton.click();
    }
}
