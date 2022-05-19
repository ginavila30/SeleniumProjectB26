package com.cydeo.test.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P13_LocateElementByXPath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        //Search for cydeo
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("cydeo"+ Keys.ENTER);
        //verify cydeo text
        WebElement cydeoText= driver.findElement(By.xpath("//h3[.='Cydeo']"));
        String actualText =cydeoText.getText();
        if(actualText.equals("Cydeo")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();
    }
}
