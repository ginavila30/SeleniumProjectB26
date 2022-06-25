package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.testng.annotations.Test;

public class LibraryLogInTest {

    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage loginPage=new LibraryLoginPage();
//        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email"));
//        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
//        loginPage.signInBtn.click();
        loginPage.login(ConfigurationReader.getProperty("library3.student.email"), ConfigurationReader.getProperty("library3.student.password"));//this method replaces the lines above
    }
    @Test
    public void negativeLoginTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage loginPage=new LibraryLoginPage();
//        loginPage.email.sendKeys("abc@gmail.com");
//        loginPage.password.sendKeys("abcd");
//        loginPage.signInBtn.click();
        loginPage.login(ConfigurationReader.getProperty("library3.student.email"), ConfigurationReader.getProperty("library3.student.password"));//this method replaces the lines above
    }

}
