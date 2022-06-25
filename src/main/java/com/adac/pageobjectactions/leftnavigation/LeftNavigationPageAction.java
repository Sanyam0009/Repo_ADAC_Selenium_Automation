package com.adac.pageobjectactions.leftnavigation;

import com.adac.pageobjects.leftnavigation.LeftNavigationPage;
import org.openqa.selenium.interactions.Actions;

public class LeftNavigationPageAction extends LeftNavigationPage {
    public void navigateToSubModule(){
        Actions action = new Actions(driver);
        action.moveToElement(leftHandNavigationBar).perform();
        leftNavMenuModuleButton("Service Plane").click();
        leftNavMenuModuleButton("Data Reliability").click();
        leftNavSubModuleButton("Service Plane", "Data Discovery").click();
    }
}
