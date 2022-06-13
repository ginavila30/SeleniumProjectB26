package com.cydeo.selenium_package.selenium.day8_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import com.cydeo.selenium_package.Utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Verify users can send message by clicking "MESSAGE" tab

Test cases #1
Description:  Users send text messages successfully
Environment:  https://login2.nextbasecrm.com/
Steps::
1.  Users are on the homepage (Login with valid username and password)
2.  Users click the MESSAGE tab
3.  Users write test message
4.  Users click the SEND button
5.  Verify the message is displayed on the feed
*/
public class Iframe_NextBaseCRM extends TestBase {
    @Test
    public void TC01(){
//        driver.get("https://login2.nextbasecrm.com/");
//        WebElement userNameInput = driver.findElement(By.xpath("//input[@class=\"login-inp\"] [@name=\"USER_LOGIN\"]"));
//        userNameInput.sendKeys("marketing25@cybertekschool.com");
//        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
//        passwordInput.sendKeys("UserUser", Keys.ENTER);
        CRM_Utilities.login_crm(driver);
        WebElement messageTab = driver.findElement(By.id("feed-add-post-form-tab-message"));
        messageTab.click();
        WebElement postTitle = driver.findElement(By.xpath("//input[@id=\"POST_TITLE\"]"));
        postTitle.sendKeys("Test123");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"bx-editor-iframe\"]"));
        driver.switchTo().frame(iframe);
        WebElement messageBox = driver.findElement(By.xpath("//body[@contenteditable=\"true\"]"));
        messageBox.sendKeys("Testing");
        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id=\"blog-submit-button-save\"]"));
        sendBtn.click();
        WebElement userPost = driver.findElement(By.xpath("//div[@class=\"feed-item-wrap\"][1]  //a[@class=\"feed-post-user-name\"]"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"feed-item-wrap\"][1]  //a[@class=\"feed-post-user-name\"]")));
        Assert.assertEquals(userPost.getText(), "marketing25@cybertekschool.com");


    }
}
