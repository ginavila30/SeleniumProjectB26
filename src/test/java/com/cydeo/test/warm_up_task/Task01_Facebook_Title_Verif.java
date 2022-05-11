package com.cydeo.test.warm_up_task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01_Facebook_Title_Verif {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.facebook.com");
String expectedTitle="Facebook - log in or sign up";
String actualTitle=driver.getTitle();

if(expectedTitle.equals(actualTitle)){
    System.out.println("Test Passed");
}else{
    System.out.println("Test Failed");
}
driver.quit();

    }
}
