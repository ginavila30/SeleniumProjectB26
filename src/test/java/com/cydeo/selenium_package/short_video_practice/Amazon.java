package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement element1= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        element1.sendKeys("dog toys"+ Keys.ENTER);
        WebElement element2= driver.findElement(By.xpath("//span[.='Dog Toys for Aggressive Chewers Large Breed,Dog Chew Toys for Small Medium Large, DogsSqueaky Toys for Dogs with Non-Toxic Natural Rubber']"));
        element2.click();
        WebElement element3= driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        element3.click();
        WebElement element4= driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
        System.out.println((element4.getText().equals("1") ? "true" : "false"));
    }

}
