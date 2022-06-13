package com.cydeo.selenium_package.short_video_practice;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends TestBase {
    @Test
    public void webTables(){
        driver.get("https://practice.cydeo.com/tables");
        WebElement row3Cell2= driver.findElement(By.xpath("(//table[@id=\"table1\"]//tbody//tr)[3]//td[2]"));
        System.out.println("Before clicking first name row3Cell2.getText() = " + row3Cell2.getText());
        WebElement firstNameTag = driver.findElement(By.xpath("(//span[.=\"First Name\"])[1]"));
        firstNameTag.click();
        row3Cell2= driver.findElement(By.xpath("(//table[@id=\"table1\"]//tbody//tr)[3]//td[2]"));
        System.out.println("After clicking first name row3Cell2.getText() = " + row3Cell2.getText());
        WebElement jason=driver.findElement(By.xpath("//table[@id=\"table1\"]//td[.=\"Jason\"]"));
        System.out.println(jason.getText());
        List<WebElement>allRow3Cells= driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr[3]//td"));
        for (WebElement each:allRow3Cells) {
            System.out.println(each.getText());
        }
        List<WebElement>allRows=driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr//td"));
        for (WebElement each:allRows) {
            System.out.println(each.getText());
        }
        List<WebElement>columnNames= driver.findElements(By.xpath("//table[@id=\"table1\"]//thead//tr//span"));
        List<String> columnNamesStr=new ArrayList<>();
        columnNames.forEach(each-> columnNamesStr.add(each.getText()));
        System.out.println(columnNamesStr);

    }
}
