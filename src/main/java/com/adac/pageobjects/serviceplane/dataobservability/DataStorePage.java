package com.adac.pageobjects.serviceplane.dataobservability;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStorePage {
    protected WebDriver driver;
    public DataStorePage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//img[contains(@src,'Redshift.png')]")
    protected WebElement amazonRedShiftImage;
}
