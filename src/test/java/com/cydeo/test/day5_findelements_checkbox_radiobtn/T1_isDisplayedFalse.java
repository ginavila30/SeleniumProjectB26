package com.cydeo.test.day5_findelements_checkbox_radiobtn;

import com.cydeo.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/*//1- Open a Chrome browser
    //2- Go to: https://www.tesla.com/
    //3- Locate Solar Panels header
    //4- Verify if it is dispayed on the page*/
public class T1_isDisplayedFalse {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.tesla.com/");
        WebElement solarPanelHeader = driver.findElement(By.xpath("(//h1[contains(text(),\"Solar Panels\")])[1]"));
        System.out.println("solarPanelHeader.isDisplayed() = " + solarPanelHeader.isDisplayed());
        driver.quit();
    }
}
