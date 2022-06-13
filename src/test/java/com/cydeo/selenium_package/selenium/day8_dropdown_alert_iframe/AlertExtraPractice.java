package com.cydeo.selenium_package.selenium.day8_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertExtraPractice extends TestBase {
    @Test
    public void Practice1() throws InterruptedException {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        WebElement alertBtn= driver.findElement(By.name("alert"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement alertBtn2= driver.findElement(By.name("confirmation"));
        alertBtn2.click();
        alert.dismiss();
        WebElement alertBtn3= driver.findElement(By.name("prompt"));
        alertBtn3.click();
        alert.sendKeys("Hello");
        alert.accept();
        //Thread.sleep(3000);
       WebElement hoverOver = driver.findElement(By.xpath("//div[@class=\"dropdown\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOver).build().perform();
      // Thread.sleep(3000);
       WebElement link1 = driver.findElement(By.xpath("//a[@id=\"link1\"]"));
       link1.click();
        Assert.assertEquals(driver.getTitle(),"CherCher Tech - Learning is fun");
        driver.navigate().back();
        WebElement button = driver.findElement(By.xpath("//input[@id=\"double-click\"]"));
        actions.doubleClick(button).perform();
        alert.accept();
    }
}
