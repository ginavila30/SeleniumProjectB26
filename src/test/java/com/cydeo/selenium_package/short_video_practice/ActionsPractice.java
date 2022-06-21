package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsPractice {
    @Test
    public void dragAndDrop() {
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement bigCir = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCir = Driver.getDriver().findElement(By.id("draggable"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCir, bigCir).perform();
        //actions.moveToElement(smallCir).pause(1000).clickAndHold().pause(1000).release(bigCir).perform();// 2nd alternative for same action
        Assert.assertEquals(bigCir.getText(), "You did great!");
        Driver.closeDriver();
    }

    @Test
    public void hoverOver() {
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        Actions action = new Actions(Driver.getDriver());
        List<WebElement> list = Driver.getDriver().findElements(By.tagName("img"));
        for (int i = 0, j=1; i < list.size() ; i++, j++) {
            action.moveToElement(list.get(i)).perform();
            String xpath1= new StringBuilder().append("//h5[.=\"name: user").append(j).append("\"]").toString();
            String xpath2= new StringBuilder().append("//a[@href=\"/users/").append(j).append("\"]").toString();
            WebElement userTitle = Driver.getDriver().findElement(By.xpath(xpath1));
            WebElement profileLink = Driver.getDriver().findElement(By.xpath(xpath2));
            Assert.assertEquals(userTitle.getText(), "name: user"+j);
            Assert.assertTrue(profileLink.isDisplayed());
            Driver.closeDriver();
        }

        }

}
