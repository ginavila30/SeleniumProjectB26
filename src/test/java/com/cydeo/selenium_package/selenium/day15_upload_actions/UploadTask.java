package com.cydeo.selenium_package.selenium.day15_upload_actions;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TC : Guru99 Upload Test

1. Go to  “http://demo.guru99.com/test/upload”
2. Upload file into Choose File
3. Click terms of servide check box
4. Click Submit File button
5. Verify expected message appeared. Expected: “1 file
has been successfully uploaded.”

  */
public class UploadTask {
  @Test
  public static void test(){
    Driver.getDriver().get("http://demo.guru99.com/test/upload");
    WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//input[@id=\"uploadfile_0\"]"));
    uploadFile.sendKeys("C:\\Users\\majid\\OneDrive\\Desktop\\2022-wrf-pre-operational-checklist_2021.03.11.pdf");
    WebElement terms = Driver.getDriver().findElement(By.xpath("//input[@id=\"terms\"]"));
    terms.click();
    WebElement button= Driver.getDriver().findElement(By.xpath("//button[@id=\"submitbutton\"]"));
    button.click();
    WebElement message = Driver.getDriver().findElement(By.xpath("//div[@class=\"formbuttons\"]//center"));
    String expectedMessage = "1 file\n" + "has been successfully uploaded.";
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
    wait.until(ExpectedConditions.visibilityOf(message));
    Assert.assertEquals(message.getText(),expectedMessage,"Result message verification failed");
    Driver.closeDriver();
  }

}
