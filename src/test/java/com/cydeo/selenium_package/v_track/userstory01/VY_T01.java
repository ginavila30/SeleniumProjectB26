package com.cydeo.selenium_package.v_track.userstory01;

import com.cydeo.selenium_package.v_track.settings.SettingUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
/*Given that I am logged in as a truck driver
When I hover over fleet module
And I click on "Vehicle Costs" button
Then I should be directed to "Vehicle Costs - Entities - System - Car - Entities - System" page
"And I should see cost information grid (TYPE
TOTAL PRICE
DATE)"*/
    @Test
    public void userSeesVehicleCostInfo() {
        Actions hoverOver= new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement fleet= driver.findElement(By.xpath("//span[contains(text(),\"Fleet\")] [@class=\"title title-level-1\"]"));
        wait.until(ExpectedConditions.visibilityOf(fleet));
        hoverOver.moveToElement(fleet).build().perform();
        WebElement vehiclesCost = driver.findElement(By.xpath("//span[.=\"Vehicle Costs\"]/.."));
        wait.until(ExpectedConditions.elementToBeClickable(vehiclesCost));
        vehiclesCost.click();
        WebElement vehicleCostGrid = driver.findElement(By.xpath("//div[@class=\"other-scroll-container\"]"));
        Assert.assertTrue(vehicleCostGrid.isDisplayed());
        String actualTitle= driver.getTitle();
        String expectedTitle= "Vehicle Costs - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle,expectedTitle);
        List<WebElement>list=driver.findElements(By.xpath("//a[@class=\"grid-header-cell__link\"]"));
        ArrayList<String>expectedList=new ArrayList<>(Arrays.asList("TYPE","TOTAL PRICE","DATE"));
        for (int i = 0; i < list.size() ; i++) {
            Assert.assertEquals(list.get(i).getText(),expectedList.get(i));
        }

    }
}
