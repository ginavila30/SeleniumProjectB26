package com.cydeo.office_hours.day01_05_17_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkText_NameLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://practice.cydeo.com/");
        WebElement signUpForMailingListButton= driver.findElement(By.partialLinkText("Sign Up For"));
        signUpForMailingListButton.click();
        String expectedTitle="Sign Up";
        String actualTitle= driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        WebElement fullNameInput= driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("John Smith");
        WebElement emailInput= driver.findElement(By.name("email"));
        emailInput.sendKeys("john@cydeo.com");
        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        expectedTitle="Signup Confirmation";
        actualTitle= driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

    }
}
