package com.cydeo.selenium_package.Utilities;

import org.openqa.selenium.WebElement;

public class Methods {
    public static String multipleElementsDisplayed(WebElement... elements){
        boolean valid= true;
        for (WebElement each:elements) {
            if(!each.isDisplayed()){
                valid=false; break;
            }
        }
        return valid?"Test Passed":"Test failed";
    }
}
