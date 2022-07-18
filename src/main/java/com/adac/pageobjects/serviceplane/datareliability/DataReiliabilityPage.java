package com.adac.pageobjects.serviceplane.datareliability;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataReiliabilityPage {
    protected WebDriver driver;
    public DataReiliabilityPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//button[@title='Data Discovery']")
    protected WebElement dataDiscoverTab;
}
