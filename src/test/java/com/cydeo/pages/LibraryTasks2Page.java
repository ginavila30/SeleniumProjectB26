package com.cydeo.pages;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryTasks2Page {
    public LibraryTasks2Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "inputEmail")
    public WebElement  emailInput;

    @FindBy (id = "inputPassword")
    public WebElement  passwordInput;

    @FindBy (css = "[type=\"submit\"]")
    public WebElement  signinBtn;

    @FindBy (css = "[class=\"alert alert-danger\"]")
    public WebElement errorMsg;



}
