package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04FullScreen {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //navigate to google and printout the tittle

        driver.get("https://www.google.com/");
        driver.findElement(By.className("MV3Tnb"));
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }
}
