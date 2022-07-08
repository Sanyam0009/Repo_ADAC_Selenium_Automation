package com.adac.login;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.openqa.selenium.By;


public class JmeterPOC extends BrowserManager {
    WebDriver driver;

    @BeforeClass
    public void initSetup() {
        driverManager("chrome");
        driver = getDriver();
    }

    @Test
    public void jmeterPOC(){
        Assert.assertTrue(driver.findElement(By.cssSelector("div.leftIcon")).isDisplayed());

        driver.findElement(By.xpath("//button[@title='Open menu']")).click();
        driver.findElement(By.xpath("//ibm-sidenav-menu[@title='Service Plane']")).click();
        driver.findElement(By.xpath("//ibm-sidenav-menu[@title='Data Reliability']")).click();
        driver.findElement(By.xpath("//ibm-sidenav-menu[@title='Service Plane']//div[text()='Data Discovery']")).click();
        driver.switchTo().frame("dataHub");

        driver.switchTo().defaultContent();


    }
}
