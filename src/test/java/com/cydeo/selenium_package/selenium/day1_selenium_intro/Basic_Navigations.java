package com.cydeo.selenium_package.selenium.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigations {
    public static void main(String[] args) throws InterruptedException {
        // set up chrome and create web driver instance
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //navigate.to(url)
//      driver.navigate().to("https://www.etsy.com");

        //make page full screen
        Thread.sleep(3000);
        driver.manage().window().maximize();//preferable
        //driver.manage().window().fullscreen();

        //driver.get(url)
        driver.get("https://www.etsy.com");
        Thread.sleep(3000);//time between actions

       //navigate.back()
        driver.navigate().back();

        //navigate.forward()
        Thread.sleep(3000);//time between actions
        driver.navigate().forward();

        //navigate.refresh();
        Thread.sleep(3000);//time between actions
        driver.navigate().refresh();

        //getTitle()
       String title=driver.getTitle();
        System.out.println("Title of Page:"+title);

        //getUrl()
        System.out.println("Current URL: "+driver.getCurrentUrl());

        driver.get("https://www.tesla.com");

        //getTitle()
        System.out.println(driver.getTitle());

        //getUrl()
        System.out.println("Current URL: "+driver.getCurrentUrl());

        //close() -> closes currently open page
        driver.close();

        //quit() -> closes the browser fully
        driver.quit();

    }
}
