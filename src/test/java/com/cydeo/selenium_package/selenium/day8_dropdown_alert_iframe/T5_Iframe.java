package com.cydeo.selenium_package.selenium.day8_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*    TC : Iframe practice

1. Go to: https://practice.cydeo.com/iframe
2. Assert: “Your content goes here.” Text is displayed.
3. Assert: “An iFrame containing the TinyMCE
WYSIWYG Editor”*/
public class T5_Iframe extends TestBase {
    @Test
    public void iFrame(){
        driver.get("https://practice.cydeo.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement contentTextMsg= driver.findElement(By.xpath("//p[.=\"Your content goes here.\"] "));
        Assert.assertTrue(contentTextMsg.isDisplayed());
        driver.switchTo().parentFrame();
        WebElement headerText = driver.findElement(By.xpath("//h3[.=\"An iFrame containing the TinyMCE WYSIWYG Editor\"] "));
        Assert.assertTrue(headerText.isDisplayed());
        Assert.assertEquals(headerText.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}
