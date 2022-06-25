package com.adac.pageobjects.login;

import com.adac.framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.Proxy;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {
        driver = BrowserManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    protected WebElement usernameTextBox;

    @FindBy(id="password")
    protected WebElement passwordTextBox;

    @FindBy(id="kc-login")
    protected WebElement signInButton;


}
