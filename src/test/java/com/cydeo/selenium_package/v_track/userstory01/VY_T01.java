package com.cydeo.selenium_package.v_track.userstory01;

import com.cydeo.selenium_package.v_track.settings.SettingUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Given that user is logged in as a truck driver user
And user is on the home page
Wen I hover over the Fleet module
And I click on Vehicle option
Then I should see the vehicles information grid
And I should be on the Car - Entities - System - Car - Entities - System page*/
public class VY_T01 extends SettingUp {
    @Test
    public void userSeesVehicleInfoGrid() throws InterruptedException {
        Actions hoverOver= new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement fleet= driver.findElement(By.xpath("//span[contains(text(),\"Fleet\")] [@class=\"title title-level-1\"]"));
        wait.until(ExpectedConditions.visibilityOf(fleet));
        hoverOver.moveToElement(fleet).build().perform();
        WebElement vehicles = driver.findElement(By.xpath("//a[@href=\"entity/Extend_Entity_Carreservation\"]"));
        wait.until(ExpectedConditions.visibilityOf(vehicles));
        vehicles.click();
        WebElement vehicleInfoGrid = driver.findElement(By.xpath("//div[@data-layout=\"separate\"][@class=\"scrollable-container disable-scroll\"]"));
        Assert.assertTrue(vehicleInfoGrid.isDisplayed());
        String actualTitle= driver.getTitle();
        String expectedTitle= "Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
