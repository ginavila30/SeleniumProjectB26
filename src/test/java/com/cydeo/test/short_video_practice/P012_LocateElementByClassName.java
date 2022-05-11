package com.cydeo.test.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P012_LocateElementByClassName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement helpfulTxt= driver.findElement(By.className("NKcBbd"));

        if(helpfulTxt.getText().equals("Helpful tips to fact check information online")){
            System.out.println("Text appears correctly");
        }else {
            System.out.println("Text does not appear correctly");
        }

        driver.quit();
    }
}
