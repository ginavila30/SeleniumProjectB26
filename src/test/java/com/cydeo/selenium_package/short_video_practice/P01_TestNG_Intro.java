package com.cydeo.selenium_package.short_video_practice;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class P01_TestNG_Intro {
    @Test(priority = 2) // I can decide the priority of the cases to run. When priority not specified, it goes by alphabetic order of the method name.
    public void testOnePlusFive(){
        System.out.println("***** Test one plus 5 running");
        assertEquals(1+5,6);
    }

    @Test(priority = 1)
    public void testTenMinusFour(){
        System.out.println("***** Test ten minus 4 running");
        assertEquals(10-4,6);
        assertTrue(2%2==0,"it fails");// message is displayed only when it fails
       // fail(); -> fails test intentionally
    }

    @BeforeClass
    public void setUp(){
        System.out.println("****** Before class is running!");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("****** After class is running!");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("****** Before method is running!");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("****** After method is running!");
    }

}
