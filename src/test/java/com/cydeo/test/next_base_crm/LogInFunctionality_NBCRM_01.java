package com.cydeo.test.next_base_crm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInFunctionality_NBCRM_01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameInputBox= driver.findElement(By.name("USER_LOGIN"));
        userNameInputBox.sendKeys("hr22@cybertekschool.com");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        WebElement passwordInputBox= driver.findElement(By.name("USER_PASSWORD"));
        passwordInputBox.sendKeys("UserUser");
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
        String expectedTitle="Portal";
        String actualTitle= driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }


    }
}
