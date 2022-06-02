package com.cydeo.selenium_package.selenium.day6_stale_element_and_testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
    @BeforeClass
    public void setUp(){
        System.out.println("Before class running");
    }
    @BeforeMethod
    public  void setUpMethod(){
        System.out.println("Before method running");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("After class running");
    }
    @AfterMethod
    public  void tearDownMethod(){
        System.out.println("After method running");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("Test 1 is running...");
        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual,expected,"Test 1 did not passed");
    }
@Test(priority=1)
    public void test2(){
        System.out.println("Test2 is running....");
        Assert.assertEquals("orange","orange","Test 2 did not pass");
    }
}
