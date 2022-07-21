package com.adac.pageobjectactions.leftnavigation;

import com.adac.pageobjects.leftnavigation.LeftNavigationPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;

public class LeftNavigationPageAction extends LeftNavigationPage {
//    public void navigateToSubMenuModule(String mainMenu, String subMenu, String subSubMenu){
//        openLeftMenuButton.click();
//        leftNavMenuModuleButton(mainMenu).click();
//        leftNavMenuModuleButton(subMenu).click();
//        leftNavSubModuleButton(mainMenu, subSubMenu).click();
//        closeLeftMenuButton.click();
//    }
//    public void navigateToSubMenu(String mainMenu, String subMenu){
//        openLeftMenuButton.click();
//        leftNavMenuModuleButton(mainMenu).click();
//        leftNavMenuModuleButton(subMenu).click();
//        closeLeftMenuButton.click();
//    }

    public void navigateToSubModule(String mainMenu, String subModule) throws InterruptedException {
        if (!leftNavMainModuleButton("Admin Plane").isDisplayed())
            openLeftMenuButton.click();
        leftNavMenuModuleButton(mainMenu).click();
        leftNavSubModuleButton(mainMenu,subModule).click();
        if (leftNavMainModuleButton("Admin Plane").isDisplayed())
            closeLeftMenuButton.click();
        Thread.sleep(2000);
    }

    public void navigateToMainModule(String mainModuleName) throws InterruptedException {
        if (!leftNavMainModuleButton("Admin Plane").isDisplayed())
            openLeftMenuButton.click();
        leftNavMainModuleButton(mainModuleName).click();
        if (leftNavMainModuleButton("Admin Plane").isDisplayed())
            closeLeftMenuButton.click();
        Thread.sleep(2000);
    }
}
