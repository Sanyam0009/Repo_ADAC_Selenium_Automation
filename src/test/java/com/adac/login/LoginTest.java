package com.adac.login;

import com.adac.framework.BrowserManager;
import com.adac.framework.FrameworkOperations;
import com.adac.pageobjectactions.leftnavigation.LeftNavigationPageAction;
import com.adac.pageobjectactions.login.LoginPageAction;
import com.adac.pageobjectactions.serviceplane.datadiscovery.DataDiscoveryPageAction;
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
    public void dataDiscoveryValidate() throws InterruptedException {
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToSubModule();
        DataDiscoveryPageAction dataDiscoveryPageAction = new DataDiscoveryPageAction();
        Thread.sleep(30);
        FrameworkOperations frameworkOperations = new FrameworkOperations();
        frameworkOperations.switchToFrameAfterWait("dataHub");
        dataDiscoveryPageAction.searchValue("SanyamTest");
    }
}
