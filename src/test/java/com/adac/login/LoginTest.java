package com.adac.login;

import com.adac.framework.BrowserManager;
import com.adac.pageobjectactions.leftnavigation.LeftNavigationPageAction;
import com.adac.pageobjectactions.login.LoginPageAction;
import com.adac.pageobjects.leftnavigation.LeftNavigationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BrowserManager{
    WebDriver driver;
    @BeforeClass
    public void initSetup(){
        driverManager("chrome");
        driver = getDriver();
    }

    @Test(priority =1)
    public void successLoginCheck(){
        LoginPageAction loginPageAction = new LoginPageAction();
        loginPageAction.adacLogin("adac","@dmin@123");
    }

    @Test(priority = 2)
    public void dataDiscoveryValidate(){
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToSubModule();
    }
}
