package com.cydeo.selenium_package.selenium.day8_dropdown_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertExtraPractice2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void alertExtraPractice1(){
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.cssSelector("#alertButton"));
        alert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }

    @Test
    public void alertExtraPractice2(){
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.id("timerAlertButton"));
        alert.click();
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }
    @Test
    public void alertExtraPractice3(){
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.cssSelector("#confirmButton"));
        alert.click();
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();
    }
    @Test
    public void alertExtraPractice4() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.cssSelector("#promtButton"));
        alert.click();
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("Gina");
        alert1.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("#promptResult")).getText(),"You entered Gina");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
