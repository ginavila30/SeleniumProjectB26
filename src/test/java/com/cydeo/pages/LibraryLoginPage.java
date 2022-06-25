package com.cydeo.pages;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="inputEmail")
    public WebElement email;

    @FindBy(id="inputPassword")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy (xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMsg;

    public void login(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.signInBtn.click();
    }

}
