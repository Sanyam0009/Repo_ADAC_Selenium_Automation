package com.adac.poc;

import com.adac.framework.BrowserManager;
import com.adac.framework.ExtentReportManager;
import com.adac.framework.FrameworkOperations;
import com.adac.pageobjectactions.adminplane.OverviewPageAction;
import com.adac.pageobjectactions.adminplane.TeamsPageActions;
import com.adac.pageobjectactions.dashboard.DashboardPageAction;
import com.adac.pageobjectactions.header.HeaderPageActions;
import com.adac.pageobjectactions.leftnavigation.LeftNavigationPageAction;
import com.adac.pageobjectactions.login.LoginPageAction;
import com.adac.pageobjectactions.operationscenter.OperationsCenterPageAction;
import com.adac.pageobjectactions.serviceplane.datadiscovery.DataDiscoveryPageAction;
import com.adac.pageobjectactions.serviceplane.dataobservability.DataStoreItemsPageAction;
import com.adac.pageobjectactions.serviceplane.dataobservability.DataStorePageAction;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class ADAC_Tenant_POC extends BrowserManager {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void initSetup(String browserName) {
        driverManager(browserName);
        driver = getDriver();
        ExtentReportManager.getExtentReport();
    }

    @Test(priority = 1)
    public void successLoginValidation() throws InterruptedException {
        LoginPageAction loginPageAction = new LoginPageAction();
        loginPageAction.adacLogin("adac", "@dmin@123");
        HeaderPageActions headerPageActions = new HeaderPageActions();

        Assert.assertTrue(headerPageActions.checkAppIconDisplayed(),
                "Expected : User should be able to Login successfully. " +
                "Actual : User is not able to Login");
    }

    @Test(priority = 2)
    public void DashboardValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Map<String,String> param= new HashMap<>();
        param.put("grant_type","password");
        param.put("username","adac");
        param.put("password","@dmin@123");
        param.put("client_id","adac-api");
        param.put("client_secret","mUHiga1IKUxc2AF9G9wFa08vWO5NucAg");
        Map<String, String> headerLoginApi = new HashMap<>();
        //header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
        headerLoginApi.put("Content-Type","application/x-www-form-urlencoded");
        Response response1 =  RestAssured.given().headers(headerLoginApi).baseUri("http://authz.adac-dev-kyndryl.com")
                .basePath("auth/realms/adac-dev-instance/protocol/openid-connect/token").formParams(param).post();
        System.out.println(response1.getBody().jsonPath().get("access_token").toString());
        String bearerToken = "Bearer " + response1.getBody().jsonPath().get("access_token").toString();

        Map<String,String> headerCommon = new HashMap<>();
        headerCommon.put("Content-Type","application/json");
        headerCommon.put("Authorization",bearerToken);

        Response response2 = RestAssured.given().headers(headerCommon).baseUri("http://adacapi.adac-dev-kyndryl.com")
                .basePath("/os/api/v2/insights/pipeline/overview").queryParam("day","1").get();
        System.out.println(response2.getBody().asString());
        JsonPath pipeLineApiJsonResp = response2.getBody().jsonPath();
        int totalPipelinesApiCount = pipeLineApiJsonResp.get("total_count");
        int upPipelinesApiCount = pipeLineApiJsonResp.get("success");
        int downPipelinesApiCount = pipeLineApiJsonResp.get("failed");
        int upDownPiplineApiTotalCount = upPipelinesApiCount + downPipelinesApiCount;
        softAssert.assertEquals(upDownPiplineApiTotalCount,totalPipelinesApiCount,
                "Expected :  Pipelines API response total counts -"+ totalPipelinesApiCount +"- should be total of Up and Down count. "
                        + "Actual : Pipelines API response Up and Down count total is - " + upDownPiplineApiTotalCount);

        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToMainModule("Dashboard");
        DashboardPageAction dashboardPageAction = new DashboardPageAction();
        int totalCount = dashboardPageAction.getDataOperationTotalCount("Pipelines");
        int upCount = dashboardPageAction.getDataOperationUpCount("Pipelines");
        int downCount = dashboardPageAction.getDataOperationDownCount("Pipelines");
        int upDownTotalCount = upCount + downCount;
        softAssert.assertEquals(upDownTotalCount,totalCount,
                "Expected : Pipelines total counts -"+ totalCount +"- should be total of Up and Down count. "
                        + "Actual : Pipelines Up and Down count total is - " + upDownTotalCount);
        softAssert.assertAll();

    }

    @Test(priority = 3, dataProviderClass = com.adac.poc.dataprovider.ADAC_Tenant_POC_Data.class , dataProvider = "createTeamVerification")
    public void AdminPlaneTeamCreationValidation(String teamName, String roleName, String description) throws InterruptedException {
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToMainModule("Admin Plane");
        OverviewPageAction overviewPageAction = new OverviewPageAction();
        overviewPageAction.clickAddTeamButton();
        TeamsPageActions teamsPageActions = new TeamsPageActions();
        FrameworkOperations frameworkOperations = new FrameworkOperations();
        String teamName1 =  "SanyamTeamT1";// + frameworkOperations.dateTimeStampGenerator();
        teamsPageActions.createTeam(teamName , roleName, description);
        String messageText = teamsPageActions.validateTeamSaveMessage();
        Assert.assertEquals(messageText,"Team has been added successfully!","Expected : Team should get saved successfully. "
                + "Actual : Team creation got failed.");
    }

    @Test(priority=4)
    public void DataObservalibilityValidation() throws InterruptedException {
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToSubModule("Service Plane","Data Observability");
        DataStorePageAction dataStorePageAction = new DataStorePageAction();
        dataStorePageAction.clickAmazonRedShiftImage();
        FrameworkOperations frameworkOperations = new FrameworkOperations();
        frameworkOperations.switchToFrameAfterWait("platformObservability");
        DataStoreItemsPageAction dataStoreItemsPageAction=new DataStoreItemsPageAction();
        Assert.assertTrue(dataStoreItemsPageAction.checkDiskSpaceUsedDisplayed(),
                "Expected : Redshift Disk Space Used card should be visible" +
                        "Actual - Redshift Redshift disk space card is not appearing");
        frameworkOperations.switchToMainFrame();

    }

    @Test(priority = 5)
    public void dataDiscoveryValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
//        Instant instantBefore = Instant.now();
        leftNavigationPageAction.navigateToSubModule("Service Plane","Data Governance");
        FrameworkOperations frameworkOperations = new FrameworkOperations();
        frameworkOperations.switchToFrameAfterWait("dataHub");
        DataDiscoveryPageAction dataDiscoveryPageAction = new DataDiscoveryPageAction();
        Assert.assertTrue(dataDiscoveryPageAction.checkSearchBarDisplayed(),"Expected : Data Discovery Page should get loaded. " +
                "Actual : Data Discovery Page is not loaded.");
//        Instant instantAfter = Instant.now();
//        Duration timeElapsed = Duration.between(instantBefore,instantAfter);
//        System.out.println("Time Elapsed is = " + timeElapsed.toSeconds());
        dataDiscoveryPageAction.searchValue("RedShift");
        Assert.assertTrue(dataDiscoveryPageAction.checkResultsTextDisplayed());
        frameworkOperations.switchToMainFrame();

    }

    @Test(priority = 6)
    public void dataIncidentsValidation() throws InterruptedException {
        LeftNavigationPageAction leftNavigationPageAction = new LeftNavigationPageAction();
        leftNavigationPageAction.navigateToSubModule("Control Plane","Data Incidents");
        Thread.sleep(3000);
        FrameworkOperations frameworkOperations = new FrameworkOperations();
        frameworkOperations.switchToFrameAfterWait("notification");
        //driver.findElement(By.cssSelector("form#auth-oidc > button[type='submit']")).click();
        OperationsCenterPageAction operationsCenterPageAction = new OperationsCenterPageAction();
        Assert.assertTrue(operationsCenterPageAction.checkSearchByDropdownDisplayed(),
                "Expected : Data Incidents page should get loaded. " +
                "Actual : Data Incidents page is not loaded.");
        operationsCenterPageAction.applyIncludeAllServicesFilter();

        Assert.assertTrue(operationsCenterPageAction.checkIncidentsExist(),
                "Expected : Incidents should be displayed on the page loaded. " +
                        "Actual : Incidents are not available.");
        frameworkOperations.switchToMainFrame();
    }

}
