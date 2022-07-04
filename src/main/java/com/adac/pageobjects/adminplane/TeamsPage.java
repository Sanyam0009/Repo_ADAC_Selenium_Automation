package com.adac.pageobjects.adminplane;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamsPage {
    protected WebDriver driver;
    public TeamsPage(){
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="input.rt-input.bx--text-input")
    protected WebElement teamNameTextBox;

    @FindBy(xpath="//span[text()='Select Roles']//parent::button")
    protected WebElement rolesDropdown;

    @FindBy(xpath="//span[contains(text(),'Description')]//parent::div//following-sibling::textarea")
    protected WebElement teamDescriptiontextArea;

    @FindBy(xpath="//button[contains(text(),'Save')]")
    protected WebElement saveButton;

    protected WebElement roleDropdownOption(String roleValue) {
        return driver.findElement(By.xpath("//*[@id='selectTeamAddEditBox']//ul//li[@title='Tester']"));
    }

}
