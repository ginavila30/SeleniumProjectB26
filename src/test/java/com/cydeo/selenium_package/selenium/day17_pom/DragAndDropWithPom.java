package com.cydeo.selenium_package.selenium.day17_pom;

import com.cydeo.pages.CydeoPracticePageDrag_DropPage;
import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/* TC #1: Cydeo Practice Drag and Drop Test
1. Open a chrome browser
2. Go to:
https://practice.cydeo.com/drag_and_drop_circles
3. Click and hold small circle
4. Move it on top of the big circle
5. And release on it.
6. Verify “You did great!” text appears on big circle */
public class DragAndDropWithPom {
   CydeoPracticePageDrag_DropPage obj = new CydeoPracticePageDrag_DropPage();

    @Test (priority = 3)
    public void task01() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.Practice.Url"));
        // CydeoPracticePage obj = new  CydeoPracticePage();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(obj.smallCir).moveToElement(obj.bigCir).release().perform();
        Assert.assertEquals(obj.bigCir.getText(), "You did great!");
        Driver.getDriver().navigate().refresh();
        System.out.println(obj.bigCir.getText());
        //  Driver.closeDriver();
    }

    /*
    TC #2: Cydeo Practice Drag and Drop Test
    1. Open a chrome browser
    2. Go to:
    https://practice.cydeo.com/drag_and_drop_circles
    3. Verify expected default text appears on big circle
       Expected = "Drag the small circle here."
     */
    @Test (priority = 1)
    public void task02() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.Practice.Url"));
        //CydeoPracticePage obj = new  CydeoPracticePage();
        Assert.assertEquals(obj.bigCir.getText(), "Drag the small circle here.");
      //  Driver.closeDriver();
    }

    /*TC #3: Cydeo Practice Drag and Drop Test
    1. Open a chrome browser
         2.  Go to:
    https://practice.cydeo.com/drag_and_drop_circles
    3. Click and hold small circle
    4. Verify "Drop here." text appears on big circle*/
    @Test(priority = 4)
    public void task03() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.Practice.Url"));
       // CydeoPracticePage obj = new  CydeoPracticePage();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(obj.smallCir).moveToElement(obj.outOfCir).perform();
        Assert.assertEquals(obj.bigCir.getText(), "Drop here.");
        //Driver.closeDriver();
    }

    /*TC #4: Cydeo Practice Drag and Drop Test
    7. Open a chrome browser
    8. Go to:
    https://practice.cydeo.com/drag_and_drop_circles
    9. Click and hold small circle
    10. Move it on top of the big circle
    11. Verify “Now drop...” text appears on big circle */
    @Test(priority = 2)
    public void task04() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.Practice.Url"));
       // CydeoPracticePage obj = new  CydeoPracticePage();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(obj.smallCir).moveToElement(obj.bigCir).perform();
        Assert.assertEquals(obj.bigCir.getText(), "Now drop...");
       // Driver.closeDriver();
    }

    /*TC #5: Cydeo Practice Drag and Drop Test
1. Open a chrome browser
2. Go to:
https://practice.cydeo.com/drag_and_drop_circles
3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. Verify “Try again!” text appears on big circle */
    @Test(priority = 5)
    public void task05() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.Practice.Url"));
       // CydeoPracticePage obj = new  CydeoPracticePage();
        Actions actions = new Actions(Driver.getDriver());
        //actions.clickAndHold(obj.smallCir).moveToElement(obj.outOfCir).release().perform();
        actions.clickAndHold(obj.smallCir).moveByOffset(600,500).release().perform();
        Assert.assertEquals(obj.bigCir.getText(), "Try again!");
       Driver.closeDriver();
    }
}
