package com.cydeo.test.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)

Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true*/
public class T4_RadioButton2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");
        List<WebElement> allButtons = driver.findElements(By.xpath("//input[@name=\"sport\"]"));
        for (WebElement eachButton : allButtons) {
            eachButton.click();
        }

        clickAndVerifyRadioButton(driver,"sport","hockey");

        driver.quit();

    }

    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idAttribute) {
        driver.get("https://practice.cydeo.com/radio_buttons");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(By.xpath("//input[@name=\"" + nameAttribute + "\"]"));
        for (WebElement element : list) {
            if (element.getAttribute("id").equals(idAttribute)) {
                element.click();
                System.out.println("Is the element selected?"+element.isSelected());
                break;
            }
        }

    }
}
