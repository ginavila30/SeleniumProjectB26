package com.cydeo.selenium_package.selenium.day7_testng_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNG_Selenium extends TestBase {
    @Test
    public void redfinSearch(){
        driver.get("https://www.redfin.com/");
        Assert.assertEquals(driver.getTitle(),"Real Estate, Homes for Sale, MLS Listings, Agents | Redfin");
        WebElement searchbox= driver.findElement(By.xpath("(//input[@id=\"search-box-input\"])[1]"));
        searchbox.sendKeys("broadland");
        List<WebElement>allSearchOptions= driver.findElements(By.xpath("//div[@class=\"item-row item-row-show-sections clickable\"]"));
        System.out.println(allSearchOptions.size());
        WebElement broadlandOption = driver.findElement(By.xpath("(//div[@class=\"item-row item-row-show-sections clickable\"])[1]"));
        broadlandOption.click();
    }
}
