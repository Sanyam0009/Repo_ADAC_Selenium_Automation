package com.adac.pageobjects.serviceplane.dataobservability;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStoreItemsPage {

    protected WebDriver driver;
    public DataStoreItemsPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="(//div[@class='embPanel']//span[text()='Disk Space Used'])[1]")
    protected WebElement diskSpaceCardHeading;

}
