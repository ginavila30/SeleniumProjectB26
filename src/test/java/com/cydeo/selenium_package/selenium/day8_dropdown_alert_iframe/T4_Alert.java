package com.cydeo.selenium_package.selenium.day8_dropdown_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.
   */

/*TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed. */

/*TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered:  hello” text is displayed.  */
public class T4_Alert extends TestBase {
     @Test
    public void warningAlert(){
         driver.get("http://practice.cydeo.com/javascript_alerts");
         WebElement JSAlertButton= driver.findElement(By.xpath("//button[.=\"Click for JS Alert\"]"));
         JSAlertButton.click();
         Alert alert= driver.switchTo().alert();
         alert.accept();
         Assert.assertTrue(driver.findElement(By.xpath("//p[.=\"You successfully clicked an alert\"]")).isDisplayed());
         Assert.assertEquals(driver.findElement(By.xpath("//p[.=\"You successfully clicked an alert\"]")).getText(),"You successfully clicked an alert","Result message failed");
     }
     @Test
    public void confirmationAlert(){
         driver.get("http://practice.cydeo.com/javascript_alerts");
         WebElement JSConfirmButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"] [.=\"Click for JS Confirm\"]"));
         JSConfirmButton.click();
         Alert alert=driver.switchTo().alert();
         alert.accept();
         WebElement resultMsg = driver.findElement(By.cssSelector("#result"));
         Assert.assertTrue(resultMsg.isDisplayed());
         Assert.assertEquals(resultMsg.getText(),"You clicked: Ok","Result message failed");
     }
     @Test
    public void promptAlert(){
         driver.get("http://practice.cydeo.com/javascript_alerts");
         WebElement JSPromptButton= driver.findElement(By.xpath("//button[.=\"Click for JS Prompt\"]"));
         JSPromptButton.click();
         Alert alert = driver.switchTo().alert();
         alert.sendKeys("hello");
         alert.accept();
         WebElement resulMsg=driver.findElement(By.id("result"));
         Assert.assertTrue(resulMsg.isDisplayed());
         Assert.assertEquals(resulMsg.getText(),"You entered: hello","Result message failed");

     }
}
