package com.adac.pageobjects.adminplane;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    protected WebDriver driver;
    public OverviewPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[contains(text(),'Add Team')]")
    protected WebElement addTeamButton;
}
