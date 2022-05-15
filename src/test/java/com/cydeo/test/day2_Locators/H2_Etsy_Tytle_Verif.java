package com.cydeo.test.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H2_Etsy_Tytle_Verif {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        WebElement searchBox= driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle= driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed Title Verification");
        }else{
            System.out.println("Failed Title Verification");
        }

        driver.quit();
    }
}
