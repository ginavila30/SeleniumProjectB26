package com.cydeo.test.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com/ ");
        WebElement inputBox= driver.findElement(By.name("q"));
        Thread.sleep(3000);
        inputBox.sendKeys("Apple");
        WebElement searchButton= driver.findElement(By.name("btnK"));
        Thread.sleep(3000);
        searchButton.click();

        String expectedTitleContent="apple";
        String actualTitle= driver.getTitle();

        if(actualTitle.startsWith(expectedTitleContent)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();

    }
}
