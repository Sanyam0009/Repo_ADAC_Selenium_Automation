package com.adac.pageobjects.operationcenter;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperationCenterPage {
    protected WebDriver driver;
    public OperationCenterPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//button[text()='Search By']")
    protected WebElement searchByDropdown;
}
