package com.cydeo.test.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H1_Back_And_Forth_Navigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebElement gmailClick= driver.findElement(By.linkText("Gmail"));
        gmailClick.click();
        String expectedTitle="Gmail";
        String actualTitle=driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.navigate().back();
        expectedTitle="Google";
        actualTitle= driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();


    }
}
