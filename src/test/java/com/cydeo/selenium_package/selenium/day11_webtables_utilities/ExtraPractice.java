package com.cydeo.selenium_package.selenium.day11_webtables_utilities;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ExtraPractice extends TestBase {
    /*TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page*/
    @Test
    public void test2(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logInBtn= driver.findElement(By.id("ctl00_MainContent_login_button"));
        logInBtn.click();
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("Links Count = " + allLinks.size());
        for (WebElement each:allLinks) {
            System.out.println("each.getText() = " + each.getText());
            System.out.println("each.getAttribute(\"href\") = " + each.getAttribute("href"));
        }
        List<WebElement>names= driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]//tr//td[2]"));
        for (WebElement each:names) {
            System.out.println(each.getText().trim().substring(each.getText().indexOf(" ")));
        }

    }
}
