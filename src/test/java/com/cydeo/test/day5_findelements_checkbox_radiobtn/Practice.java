package com.cydeo.test.day5_findelements_checkbox_radiobtn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cydeo.com/?mn=cy2NChKvVYhm2vbLzLAKHYSj26Mt36cTVYN1.BdAvNu0NjhH3_Jth");
        System.out.println(driver.findElement(By.linkText("Partnerships")).getText());
    }
}
