package com.adac.pageobjects.leftnavigation;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigationPage {
    protected WebDriver driver;
    public LeftNavigationPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "bx--side-nav__items")
    protected WebElement leftHandNavigationBar;

    @FindBy(xpath="//button[@title='Open menu']")
    protected WebElement openLeftMenuButton;

    @FindBy(xpath="//button[@title='Close menu']")
    protected WebElement closeLeftMenuButton;



    protected WebElement leftNavMainModuleButton(String navBarMainModuleButtonName){
        return driver.findElement(By.xpath("//ibm-sidenav-item//span[contains(text(),'"+  navBarMainModuleButtonName +"')]"));
    }

    protected WebElement leftNavMenuModuleButton(String navBarMenuModuleButtonName){
        return driver.findElement(By.xpath("//ibm-sidenav-menu[@title='"+ navBarMenuModuleButtonName +"']"));
    }
    protected WebElement leftNavSubModuleButton(String navBarModuleButtonName,String navBarSubModuleButtonName){
        return driver.findElement(By.xpath("//ibm-sidenav-menu[@title='"+ navBarModuleButtonName +"']" +
                "//div[text()='"+ navBarSubModuleButtonName +"']"));
    }
}
