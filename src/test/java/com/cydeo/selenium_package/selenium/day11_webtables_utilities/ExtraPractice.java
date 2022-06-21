package com.cydeo.selenium_package.selenium.day11_webtables_utilities;

import com.cydeo.base.TestBase;
import com.cydeo.selenium_package.Utilities.Driver;
import com.cydeo.selenium_package.Utilities.SmartBearUtils;
import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ExtraPractice extends TestBase {
    /*TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page*/
    @Test
    public void test1(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logInBtn= driver.findElement(By.id("ctl00_MainContent_login_button"));
        logInBtn.click();
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("Links Count = " + allLinks.size());
        for (WebElement each:allLinks) {
            System.out.println("each.getText() = " + each.getText());
            System.out.println("each.getAttribute(\"href\") = " + each.getAttribute("href"));
        }
        List<WebElement>names= driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]//tr//td[2]"));
        for (WebElement each:names) {
            System.out.println(each.getText().trim().substring(each.getText().indexOf(" ")));
        }
    }
    /*TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”

 */
    @Test
    public void test2(){
       WebDriver driver= Driver.getDriver();
       SmartBearUtils.loginToSmartBear(driver);
       WebElement orderBtn = driver.findElement(By.xpath("//a[@href=\"Process.aspx\"] "));
       orderBtn.click();
        Select select= new Select(driver.findElement(By.xpath("//select[@id=\"ctl00_MainContent_fmwOrder_ddlProduct" +
                "\"]")));
        select.selectByValue("FamilyAlbum");
        WebElement quantityBox = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"] "));
        quantityBox.clear();
        quantityBox.sendKeys("2");
        WebElement calculateBtn = driver.findElement(By.xpath("//input[@value=\"Calculate\"] "));
        calculateBtn.click();
        WebElement costumerName= driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        Faker faker = new Faker();
        costumerName.sendKeys(faker.name().fullName());
        WebElement streetBox = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]"));
        streetBox.sendKeys(faker.address().streetAddress());
        WebElement city = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]"));
        city.sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"));
        state.sendKeys(faker.address().state());
        WebElement zipcode = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"] "));
        zipcode.sendKeys(faker.address().zipCode().replace("-",""));
        WebElement visaBtn = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]"));
        visaBtn.click();
        WebElement cardNum = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
        cardNum.sendKeys(faker.finance().creditCard(CreditCardType.VISA).replace("-",""));
        WebElement date = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
        date.sendKeys("12/26");
        WebElement processBtn = driver.findElement(By.xpath("//a[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]"));
        processBtn.click();
        WebElement msg = driver.findElement(By.xpath("//strong[contains(.,\"New order has been successfully added.\")]"));
        Assert.assertEquals(msg.getText(),"New order has been successfully added.");
        System.out.println(driver.findElement(By.xpath("//div[@class=\"buttons_process\"]//strong")).getText());

    }
    /*TC#3: Smartbear software order verification
1. Open browser and login to Smartbear software
2. Click on View all orders
3. Verify Susan McLaren has order on date “01/05/2010”*/
    @Test
    public void test3(){
        WebDriver driver =Driver.getDriver();
        SmartBearUtils.loginToSmartBear(driver);
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[.=\"View all orders\"]"));
        viewAllOrders.click();
        WebElement orderDate= driver.findElement(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]//td[.=\"Susan McLaren\"]//following-sibling::td[3]"));
        Assert.assertEquals(orderDate.getText(),"01/05/2010");
        Driver.closeDriver();
    }
    /*
TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332 */
    @Test
    public void test4(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.openxcell.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        Assert.assertTrue(links.size()>=332);
    }
    /*TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page
 */
    @Test
    public void test5(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.openxcell.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement each:links) {
            try {if(!each.getText().isEmpty()){
                System.out.println(each.getText());
            }
            }catch (StaleElementReferenceException e){
                e.getMessage();
            }
        }
        Driver.closeDriver();
        }
        /*TC #3: Counting the number of links that does not have text
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of links that does not have text and verify
Expected: 109 */
        @Test
        public void test6() {
            WebDriver driver = Driver.getDriver();
            driver.get("https://www.openxcell.com");
            List<WebElement> links = driver.findElements(By.tagName("a"));

           int count = 0;

            for (WebElement each : links) {
                try {
                    if (each.getText().isEmpty()) {
                        count++;
                    }
                } catch (StaleElementReferenceException e) {
                    e.getMessage();
                }
            }
            System.out.println(count);
            Driver.closeDriver();
        }
        /*Task #: Gas Mileage Calculator Automation Test

1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link
5. On Next page verify:
a. Title equals: “Gas Mileage Calculator”
b. “Gas Mileage Calculator” label is displayed
 6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mpg”       */
    @Test
    public void test7(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.calculator.net");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"calcSearchTerm\"]"));
        searchBox.sendKeys("gas mileage");
        WebElement gasMileageLink = driver.findElement(By.xpath("//a[@href=\"/gas-mileage-calculator.html\"]"));
        gasMileageLink.click();
        Assert.assertEquals(driver.getTitle(),"Gas Mileage Calculator");
        WebElement header= driver.findElement(By.xpath("//h1[.=\"Gas Mileage Calculator\"]"));
        Assert.assertTrue(header.isDisplayed());
        WebElement currentOdometer = driver.findElement(By.xpath("//input[@id=\"uscodreading\"]"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");
        WebElement prevOdometer = driver.findElement(By.xpath("//input[@id=\"uspodreading\"]"));
        prevOdometer.clear();
        prevOdometer.sendKeys("7550");
        WebElement gasAdded = driver.findElement(By.xpath("//input[@id=\"usgasputin\"]"));
        gasAdded.clear();
        gasAdded.sendKeys("16");
        WebElement gasPrice = driver.findElement(By.xpath("//input[@id=\"usgasprice\"]"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");
        WebElement calculate = driver.findElement(By.xpath("//table[@id=\"standard\"]//input[@alt=\"Calculate\"]"));
        calculate.click();
        WebElement mpgValue= driver.findElement(By.xpath("//b[contains(.,\"mpg\")]"));
        Assert.assertEquals(mpgValue.getText(),"23.44 mpg");

    }
}

