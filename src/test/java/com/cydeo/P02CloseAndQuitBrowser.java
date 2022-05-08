package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02CloseAndQuitBrowser {
    public static void main(String[] args) throws InterruptedException {
        // set up chrome and create web driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //navigate to a practice page that open new tab
        //This practice url will open and wait 3 sec and open new tab
        driver.get("http://practice.cydeo.com/open_new_tab");
        Thread.sleep(5000);
        driver.close();// closes the current tab
        driver.quit();// closes the browser window opened by the driver
    }
}
