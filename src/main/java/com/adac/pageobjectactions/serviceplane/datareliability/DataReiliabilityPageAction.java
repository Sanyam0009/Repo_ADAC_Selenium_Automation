package com.adac.pageobjectactions.serviceplane.datareliability;

import com.adac.framework.FrameworkOperations;
import com.adac.pageobjects.serviceplane.datareliability.DataReiliabilityPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DataReiliabilityPageAction extends DataReiliabilityPage {
    public void clickOnDataDiscoveryTab() throws InterruptedException {
        Thread.sleep(5000);
        dataDiscoverTab.click();

    }
}
