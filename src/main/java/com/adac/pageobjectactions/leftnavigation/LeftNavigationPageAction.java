package com.adac.pageobjectactions.leftnavigation;

import com.adac.pageobjects.leftnavigation.LeftNavigationPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;

public class LeftNavigationPageAction extends LeftNavigationPage {
    public void navigateToSubMenuModule(String mainMenu, String subMenu, String subSubMenu){
        openLeftMenuButton.click();
        leftNavMenuModuleButton(mainMenu).click();
        leftNavMenuModuleButton(subMenu).click();
        leftNavInnerSubModuleButton(mainMenu, subSubMenu).click();
        closeLeftMenuButton.click();
    }
    public void navigateToSubMenu(String mainMenu, String subMenu){
        openLeftMenuButton.click();
        leftNavMenuModuleButton(mainMenu).click();
        leftNavMenuModuleButton(subMenu).click();
        closeLeftMenuButton.click();
    }

    public void navigateToSubModule(String mainMenu, String subModule){
        openLeftMenuButton.click();
        leftNavMenuModuleButton(mainMenu).click();
        leftNavSubModuleButton(mainMenu,subModule).click();
        closeLeftMenuButton.click();
    }

    public void navigateToMainModule(String mainModuleName){
        openLeftMenuButton.click();
        leftNavMainModuleButton(mainModuleName).click();
        closeLeftMenuButton.click();
    }
}
