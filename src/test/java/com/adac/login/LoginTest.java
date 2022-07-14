package com.adac.login;

import com.adac.framework.BrowserManager;
import com.adac.framework.ExtentReportManager;
import com.adac.framework.FrameworkOperations;
import com.adac.pageobjectactions.adminplane.OverviewPageAction;
import com.adac.pageobjectactions.adminplane.TeamsPageActions;
import com.adac.pageobjectactions.header.HeaderPageActions;
import com.adac.pageobjectactions.leftnavigation.LeftNavigationPageAction;
import com.adac.pageobjectactions.login.LoginPageAction;
import com.adac.pageobjectactions.operationcenter.OperationCenterPageAction;
import com.adac.pageobjectactions.serviceplane.datadiscovery.DataDiscoveryPageAction;
import com.adac.pageobjects.operationcenter.OperationCenterPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.Instant;

public class LoginTest extends BrowserManager {
    WebDriver driver;

    @BeforeClass
    public void initSetup() {
        driverManager("chrome");
        driver = getDriver();
        ExtentReportManager.getExtentReport();
    }

    @Test(priority = 1)
    public void successLoginCheck() {
        LoginPageAction loginPageAction = new LoginPageAction();
        loginPageAction.adacLogin("adac", "@dmin@123");
        HeaderPageActions headerPageActions = new HeaderPageActions();

        Assert.assertTrue(headerPageActions.checkAppIconDisplayed(),
                "Expected : User should be able to Login successfully" +
                "Actual : User is not able to Login");
    }

    @Test(priority = 2)
    public void dataDiscoveryValidate() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
//        Instant instantBefore = Instant.now();
        leftNavigationPageAction.navigateToSubModule("Service Plane","Data Reliability","Data Discovery");
        FrameworkOperations frameworkOperations = new FrameworkOperations();
        frameworkOperations.switchToFrameAfterWait("dataHub");
        DataDiscoveryPageAction dataDiscoveryPageAction = new DataDiscoveryPageAction();
        Assert.assertTrue(dataDiscoveryPageAction.checkSearchBarDisplayed(),"Expected : Data Discovery Page should get loaded" +
                "Actual : Data Discovery Page is not loaded");
//        Instant instantAfter = Instant.now();
//        Duration timeElapsed = Duration.between(instantBefore,instantAfter);
//        System.out.println("Time Elapsed is = " + timeElapsed.toSeconds());
        dataDiscoveryPageAction.searchValue("RedShift");
        Assert.assertTrue(dataDiscoveryPageAction.checkResultsTextDisplayed());
        frameworkOperations.switchToMainFrame();

    }

    @Test(priority = 3)
    public void createTeamVerification() throws InterruptedException {
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToMainModule("Admin Plane");
        OverviewPageAction overviewPageAction = new OverviewPageAction();
        overviewPageAction.clickAddTeamButton();
        TeamsPageActions teamsPageActions = new TeamsPageActions();
        teamsPageActions.createTeam("SanyamTeamT1", "Tester", "TestDesc");

//        Response response =  RestAssured.given().baseUri("http://keycloak.adac-dev-kyndryl.com")
//                .basePath("/auth/admin/realms/adac-dev-instance/groups")
//                .get();
//        System.out.println(response.getBody().asString());

    }

    @Test(priority = 4)
    public void OperationCenterTest(){
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToMainModule("Operations Center");
        FrameworkOperations frameworkOperations = new FrameworkOperations();
        frameworkOperations.switchToFrameAfterWait("notification");
        //driver.findElement(By.cssSelector("form#auth-oidc > button[type='submit']")).click();
        OperationCenterPageAction operationCenterPageAction = new OperationCenterPageAction();
        Assert.assertTrue(operationCenterPageAction.checkSearchByDropdownDisplayed(),
                "Expected : Operation center page should get loaded" +
                "Actual : Operation center page is not loaded");
        operationCenterPageAction.clickSearchByDropdown();
    }
}
