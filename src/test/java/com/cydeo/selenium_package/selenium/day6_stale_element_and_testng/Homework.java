package com.cydeo.selenium_package.selenium.day6_stale_element_and_testng;

import com.cydeo.selenium_package.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

/*TC: Etsy checkbox and radio button
1. Go to https://www.etsy.com
2. Search for “wooden spoon”
3. Click on filters
4. Select free shipping, on sale
5. Select under $25 Click on apply filters
6. Print count of results */
public class Homework {
    WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    //      Practicing Manual set up->
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    @BeforeMethod
    public void setUpMethod() {
        driver.get("https://www.etsy.com");
    }

    @Test
    public void etsySearchResult() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
        WebElement filter = driver.findElement(By.xpath("//span[.=\"All Filters\"]"));
        filter.click();
        //Thread.sleep(3000);
        WebElement freeShippingBox = driver.findElement(By.xpath("//label[@for=\"special-offers-free-shipping\"]"));
        freeShippingBox.click();
        WebElement onSaleBox = driver.findElement(By.xpath("//label[@for=\"special-offers-on-sale\"] "));
        onSaleBox.click();
        WebElement under25 = driver.findElement(By.cssSelector("label[for=\"price-input-1\"] "));
        under25.click();
        WebElement applyFiltersBtn = driver.findElement(By.xpath("//button[@class=\"wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3\"]"));
        applyFiltersBtn.click();
        Thread.sleep(3000);
        WebElement countResults = driver.findElement(By.xpath("//span[@class=\"wt-display-inline-flex-sm\"]/span[1]"));
        System.out.println(countResults.getText());
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void display(){
        System.out.println("displaying");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

