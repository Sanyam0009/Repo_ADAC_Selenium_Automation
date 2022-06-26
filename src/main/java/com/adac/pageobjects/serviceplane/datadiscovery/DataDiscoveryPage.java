package com.adac.pageobjects.serviceplane.datadiscovery;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDiscoveryPage {
    WebDriver driver;

    public DataDiscoveryPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath= "//input[@data-testid='search-input']")
    protected WebElement searchTextBar;

}
