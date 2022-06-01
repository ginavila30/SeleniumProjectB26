package com.cydeo.selenium_package.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.xpath("//div[@class='nav-search-field ']//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("dog toys"+ Keys.ENTER);
        WebElement toyLink= driver.findElement(By.xpath("//span[.='Amazon Basics Natural Rubber Pet Treat Toy']"));
        toyLink.click();
    }
}
