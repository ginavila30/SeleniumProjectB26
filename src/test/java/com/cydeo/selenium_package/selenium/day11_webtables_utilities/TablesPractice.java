package com.cydeo.selenium_package.selenium.day11_webtables_utilities;

import com.cydeo.base.TestBase;
import com.cydeo.selenium_package.Utilities.WebTablesUtils;
import org.testng.annotations.Test;
/*TC #1: Web table practice
 1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */
//I did extra practices on how to access info

public class TablesPractice extends TestBase {
@Test
    public void practice(){
    driver.get("https://practice.cydeo.com/web-tables");
//    WebElement row7cell2 = driver.findElement(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]//td[.=\"Bob Martin\"]"));
//    Assert.assertEquals(row7cell2.getText(),"Bob Martin");
//    WebElement row7cell5 = driver.findElement(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]//td[.=\"Bob Martin\"]//following-sibling::td[3]"));
//    Assert.assertEquals(row7cell5.getText(),"12/31/2021");
//    List<WebElement> columnsTitle= driver.findElements(By.xpath("//table[@class=\"SampleTable\"]//tr[1]//th"));
//    columnsTitle.forEach(each-> System.out.println(each.getText()));
//    List<WebElement>names= driver.findElements(By.xpath("//table[@class=\"SampleTable\"]//tr//td[2]"));
//    names.forEach(each-> System.out.println(each.getText()));
//    List<WebElement>bobFullOrder = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]//tr[7]//td"));
//    Map<String,String> data= new LinkedHashMap<>();
//    for (int i = 0; i <bobFullOrder.size() ; i++) {
//        data.put(columnsTitle.get(i).getText(),bobFullOrder.get(i).getText());
//    }
//    System.out.println(data);
//    Assert.assertEquals(data.get("Name"),"Bob Martin");
//    Assert.assertEquals(data.get("Date"),"12/31/2021");
//    List<WebElement>allContent= driver.findElements(By.xpath("//table[@class=\"SampleTable\"]//tr//td"));
//    allContent.forEach(each-> System.out.println(each.getText()));

    System.out.println(WebTablesUtils.returnOrderDate(driver, "Bart Fisher"));
    System.out.println(WebTablesUtils.returnOrderDate(driver, "Ned Stark"));
    WebTablesUtils.orderVerify(driver,"Ned Stark","05/12/2021");


}

}
