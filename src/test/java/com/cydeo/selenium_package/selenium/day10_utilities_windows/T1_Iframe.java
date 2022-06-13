package com.cydeo.selenium_package.selenium.day10_utilities_windows;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TC  #1: Iframe Task
1- Open a chrome browser
2- Go to:  https://login2.nextbasecrm.com/
3- Login Homepage ( Login with valid username and
password)
4- Click the MORE tab and select APPRECIATION
5- Write an Appreciation message
6- Click the SEND button
7- Verify the Appreciation message is displayed on
the feed
     */
public class T1_Iframe extends TestBase {
    @Test
    public void test(){
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameInput = driver.findElement(By.xpath("//input[@class=\"login-inp\"] [@name=\"USER_LOGIN\"]"));
        userNameInput.sendKeys("hr25@cybertekschool.com");
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("UserUser", Keys.ENTER);
        WebElement moreBtn= driver.findElement(By.cssSelector("[id=\"feed-add-post-form-link-text\"]"));
        moreBtn.click();
        WebElement appreciation = driver.findElement(By.xpath("//span[.=\"Appreciation\"]"));
        appreciation.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"bx-editor-iframe\"]")));
        WebElement msgBox=driver.findElement(By.xpath("//body[@contenteditable=\"true\"]"));
        msgBox.sendKeys("Practice");
        driver.switchTo().defaultContent();
        WebElement sendBtn= driver.findElement(By.cssSelector(
                "[id*=\"blog-submit-button-save\"]"));
        sendBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement postName = driver.findElement(By.xpath("(//a[@class=\"feed-post-user-name\"]) [1]"));
        wait.until(ExpectedConditions.visibilityOf(postName));

        Assert.assertEquals(postName.getText(),"hr25@cybertekschool.com");
        WebElement postBody= driver.findElement(By.xpath("(//div[@class=\"feed-post-text-block-inner-inner\"])[1]"));
        Assert.assertEquals(postBody.getText(),"Practice");
        Assert.assertTrue(postBody.isDisplayed());
        Assert.assertTrue(postName.isDisplayed());


    }
}
