package com.adac.pageobjects.dashboard;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    protected WebDriver driver;
    public DashboardPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected WebElement dataOperationTotalCountText(String dataOperationType){
        return driver.findElement(By.xpath("//div[@class='dd-da-tt' and text()='Pipelines']//preceding-sibling::div"));
    }

    protected WebElement dataOperationUpCountText(String dataOperationType){
        return driver.findElement(By.xpath("//div[@class='dd-da-tt' and text()='Pipelines']"+
                "//following-sibling::div//div[@class='dd-value-up']"));
    }
    protected WebElement dataOperationDownCountText(String dataOperationType){
        return driver.findElement(By.xpath("//div[@class='dd-da-tt' and text()='Pipelines']"+
                "//following-sibling::div//div[@class='dd-value-dn']"));
    }

}
