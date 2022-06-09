package com.cydeo.selenium_package.v_track;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VtrackExample extends TestBase {
    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement usernameBox= driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("user36", Keys.TAB);
        WebElement passwordBox = driver.findElement(By.id("prependedInput2") );
        passwordBox.sendKeys("UserUser123");
        WebElement logInBtn = driver.findElement(By.id("_submit"));
        logInBtn.click();
        WebElement fleet = driver.findElement(By.xpath("(//span[@class=\"title title-level-1\"])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(fleet).build().perform();
        Thread.sleep(3000);
        WebElement vehicles = driver.findElement(By.xpath("//a[@href=\"entity/Extend_Entity_Carreservation\"]"));
        vehicles.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleContains("Car - Entities - System - Car - Entities - System"));

        Assert.assertEquals(driver.getTitle(),"Car - Entities - System - Car - Entities - System");

        //WebElement odometer = driver.findElement(By.xpath("//li[@class=\"dropdown-menu-single-item\"]//a[@href=\"/entity/Extend_Entity_VehiclesOdometer\"]"));
//WebElement fuelLogs = driver.findElement(By.xpath("//li[@class=\"dropdown-menu-single-item\"]//a[@href=\"/entity/Extend_Entity_VehicleFuelLogs\"]"));
//WebElement fuelLog = driver.findElement(By.xpath("//a[@href=\"entity/Extend_Entity_Carreservation\"]"));








    }
}
