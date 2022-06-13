package com.cydeo.selenium_package.selenium.day11_webtables_utilities;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class TablesPractice2 extends TestBase {
    @Test
    public void findElements(){
        //P1_ WRITE A LOCATOR THAT RETURNS THE TABLE 1 ITSELF
        driver.findElement(By.xpath("//table[@id=\"table1\"]"));
        //P2_ WRITE A LOCATOR THAT RETURNS ALL OF THE ROWS INSIDE OF TABLE 1
        driver.findElements(By.xpath("//table[@id=\"table1\"]//tr"));
        //P3_ WRITE A LOCATOR THAT RETURNS ALL OF THE ROWS INSIDE OF BODY - TABLE 1
        driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr"));
        //P4_ WRITE A LOCATOR THAT RETURNS ONLY 3RD ROW IN THE BODY
        driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr[3]"));
        //P5_ WRITE A LOCATOR THAT RETURNS ALL OF THE CELLS IN ALL OF THE ROW (IN BODY)
        driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//td"));
        //P6_ WRITE A LOCATOR THAT RETURNS ALL OF THE FIRST NAMES FROM TABLE
        driver.findElement(By.xpath("//table[@id=\"table1\"]//tbody//tr//td[1]"));
        //P7_ WRITE A LOCATOR THAT RETURNS FRANKS CELL SPECIFICALLY//P8_ WRITE A LOCATOR THAT RETURNS FRANKS CELL SPECIFICALLY USE FRANKS TEXT
        driver.findElement(By.xpath("//table[@id=\"table1\"]//tr//td[.=\"Frank\"]"));
        //P9_ WRITE A LOCATOR THAT RETURNS $51 CELL SPECIFICALLY USE FRANKS TEXT
        driver.findElement(By.xpath("//table[@id=\"table1\"]//tbody//tr//td[.=\"Frank\"]//following-sibling::td[contains(.,\"51\")]"));
        //P10_ WRITE A LOCATOR THAT RETURNS JASONS DUE AMOUNT BASED ON JASONS NAME
        driver.findElement(By.xpath("//table[@id=\"table1\"]//tbody//tr//td[.=\"Jason\"]//following-sibling::td[2]"));
        //P11_ WRITE A LOCATOR THAT RETURNS Tim's last name  BASED ON tim's NAME
        driver.findElement(By.xpath("//table[@id=\"table1\"]//tbody//tr//td[.=\"Tim\"]//preceding-sibling::td"));
        //P12_ WRITE A LOCATOR THAT RETURNS ALL EMAILS THAT HAS $50 DUE DATE
        driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr//td[.=\"$50.00\"]//following-sibling::td[1]"));




    }
}
