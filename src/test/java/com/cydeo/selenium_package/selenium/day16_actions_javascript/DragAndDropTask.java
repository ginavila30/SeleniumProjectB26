package com.cydeo.selenium_package.selenium.day16_actions_javascript;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
/*TC : Guru99 Drag and Drop Test
1- Open a chrome browser
2- Go to: https://demo.guru99.com/test/drag_drop.html
3- Drag “BANK” and drop into Account area under Debit
Side
4- Drag “5000” and drop into Amount area under Debit Side
5- Drag “SALES” and drop into Account area under Credit
Side
6- Drag “5000” and drop into Amount area under Credit
Side
7- Verify “Perfect!” text displayed.  */
public class DragAndDropTask {
    @Test
    public static void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.url"));
        WebElement bank =Driver.getDriver().findElement(By.partialLinkText("BANK"));
        WebElement accountDebit = Driver.getDriver().findElement(By.id("bank"));
        WebElement fiveK= Driver.getDriver().findElement(By.id("fourth"));
        WebElement amountDebit= Driver.getDriver().findElement(By.id("amt7"));
        WebElement sales = Driver.getDriver().findElement(By.partialLinkText("SALES"));
        WebElement accountCredit= Driver.getDriver().findElement(By.id("loan"));
        WebElement amountCredit=Driver.getDriver().findElement(By.id("amt8"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bank,accountDebit).perform();
        actions.dragAndDrop(fiveK,amountDebit).perform();
        actions.dragAndDrop(sales,accountCredit).perform();
        actions.dragAndDrop(fiveK,amountCredit).perform();

        WebElement message= Driver.getDriver().findElement(By.linkText("Perfect!"));
        Assert.assertEquals(message.getText(),"Perfect!");
        Assert.assertTrue(message.isDisplayed());
        Driver.closeDriver();
    }
}
