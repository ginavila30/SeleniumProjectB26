package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TesBaseUsage extends TestBase {
@Test
    public void googleTitle(){
    driver.get("https://www.google.com/");
    Assert.assertEquals(driver.getTitle(),"Google");
}
}
