package com.cydeo.test.next_base_crm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class LogInFunctionality_NBCRM_04 {
    public static void main(String[] args) {
        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("helpdesk22@hotmail.com", "marketing22@gmail.com", "hr22@yahoo.com"));
        String password="wrong";
        for (String each:usernames) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameInputBox= driver.findElement(By.name("USER_LOGIN"));
        userNameInputBox.sendKeys(each);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        WebElement passwordInputBox= driver.findElement(By.name("USER_PASSWORD"));
        passwordInputBox.sendKeys(password);
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
        WebElement invalidMessage= driver.findElement(By.className("errortext"));

        String actualInvalidText= invalidMessage.getText();
        String expectedInvalidTest="Incorrect login or password";
        if(actualInvalidText.equals(expectedInvalidTest)){
            System.out.println(each+" Test Passed");
        }else {
            System.out.println(each+" Test Failed");
        }
        driver.quit();
    }
}}
