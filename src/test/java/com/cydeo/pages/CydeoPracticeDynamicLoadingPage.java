package com.cydeo.pages;

import com.cydeo.selenium_package.Utilities.ConfigurationReader;
import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoPracticeDynamicLoadingPage {
    public CydeoPracticeDynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//button[.=\"Start\"]")
  public  WebElement startBtn;

    @FindBy (id = "username")
  public  WebElement usernameBox;

    @FindBy (id = "pwd")
  public   WebElement passwordBox;

    @FindBy (css = "[type=\"submit\"]")
  public  WebElement signinBtn;

    @FindBy (css = "[type=\"checkbox\"]")
  public  WebElement rememberMeCheck;

    @FindBy(xpath = "//h4[.=\"Hello World!\"]")
public WebElement helloWorld;

    @FindBy(css = "[src=\"/img/ajax-loader.gif\"]")
    public WebElement loadingBar;

    @FindBy(css = ".flash.error")
    public  WebElement errorMessage;

    public void goTo(){
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.Practice.Url.dynamic.loading"));
    }


}
