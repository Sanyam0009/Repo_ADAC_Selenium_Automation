package com.adac.pageobjects.operationscenter;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OperationsCenterPage {
    protected WebDriver driver;
    public OperationsCenterPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//button[text()='Search By']")
    protected WebElement searchByDropdown;

    @FindBy(xpath="//span[text()='Include All Services']//preceding-sibling::span//input")
    protected WebElement includeAllServicesToggleButton;


    @FindBy(xpath="//button[text()='Done']")
    protected WebElement searchByDoneButton;

    @FindBy(xpath="//a[contains(@class,'MuiTableRow-root')]")
    protected List<WebElement> incidentRows;
}
