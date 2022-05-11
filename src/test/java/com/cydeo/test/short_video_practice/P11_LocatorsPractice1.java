package com.cydeo.test.short_video_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P11_LocatorsPractice1 {
    public static void main(String[] args) throws InterruptedException {

        //Setting up Webdriver Manager
        WebDriverManager.chromedriver().setup();

        //Creating instance of Web driver
        WebDriver driver=new ChromeDriver();

        //Maximizing page to access all content
        driver.manage().window().maximize();

        //getting the needed url
        driver.get("https://app.vytrack.com/user/login");

        //Enter Username provided "abcd"
        WebElement userNameBox= driver.findElement(By.id("prependedInput"));
        userNameBox.sendKeys("abcd");
        Thread.sleep(3000);

        //Enter Username provided "abcd"
        WebElement passwordBox= driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("abcd");
        Thread.sleep(3000);

       //Click login button
        WebElement loginButton= driver.findElement(By.id("_submit"));
        loginButton.click();

        //Verify the message "Invalid user name or password."
        WebElement warningMessage=driver.findElement(By.className("alert"));
        if(warningMessage.getText().equals("Invalid user name or password.")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

       //Verify URL contains "vytrack"
        String actualUrl=driver.getCurrentUrl();
        String expectedContent="vytrack";
        if(actualUrl.contains(expectedContent)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }

        //Click "Forgot your password?
        WebElement forgotPasswordButton= driver.findElement(By.linkText("Forgot your password?"));
        forgotPasswordButton.click();

        //Verify title is "Forgot Password"
        WebElement forgotPassword=driver.findElement(By.className("title"));
        if(forgotPassword.getText().equals("Forgot Password")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test failed");
        }

        //quit
        driver.quit();

    }
}
