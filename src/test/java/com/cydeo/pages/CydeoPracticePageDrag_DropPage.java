package com.cydeo.pages;

import com.cydeo.selenium_package.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoPracticePageDrag_DropPage {
    public CydeoPracticePageDrag_DropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "droptarget")
    public WebElement bigCir;

    @FindBy (id = "draggable")
    public WebElement smallCir;

    @FindBy (id = "flash-messages")
    public WebElement outOfCir;


}
