package com.cydeo.test.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H3_Cydeo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/inputs");
        WebElement homeClickButton= driver.findElement(By.linkText("Home"));
        homeClickButton.click();

        String expectedTitle="Practice";
        String actualTitle= driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed Title Verification");
        }else {
            System.out.println("Failed Title Verification");
        }

    }
}
