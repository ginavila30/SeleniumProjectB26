package com.cydeo.selenium_package.selenium.day5_findelements_checkbox_radiobtn;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*TC #4: FindElements Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate all the links in the page.
4- Print out the number of the links on the page.
5- Print out the texts of the links.
6- Print out the HREF attribute values of the links*/
public class T2_FindElementsMethod {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // gives additional time in case web element is not found yet. Better than thread sleep because it does not stop application it only triggers when element is not found right away.
        driver.get("https://practice.cydeo.com/abtest");

        List<WebElement> allLinks=driver.findElements(By.tagName("a"));

        System.out.println("Number of links: "+allLinks.size());
        for (WebElement eachLink:allLinks) {
            System.out.println("Text of the links: "+eachLink.getText());
            System.out.println("HREF attribute: "+eachLink.getAttribute("href"));
        }

        driver.quit();
    }
}
