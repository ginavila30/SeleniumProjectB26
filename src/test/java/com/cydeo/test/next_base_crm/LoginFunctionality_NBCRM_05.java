package com.cydeo.test.next_base_crm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFunctionality_NBCRM_05 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameInputBox= driver.findElement(By.name("USER_LOGIN"));
        userNameInputBox.sendKeys("");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        WebElement passwordInputBox= driver.findElement(By.name("USER_PASSWORD"));
        passwordInputBox.sendKeys("");
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
        WebElement invalidMessage= driver.findElement(By.className("errortext"));

        String actualInvalidText= invalidMessage.getText();
        String expectedInvalidTest="Incorrect login or password";
        if(actualInvalidText.equals(expectedInvalidTest)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }
}
