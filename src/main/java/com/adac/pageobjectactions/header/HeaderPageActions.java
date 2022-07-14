package com.adac.pageobjectactions.header;

import com.adac.pageobjects.header.HeaderPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;

public class HeaderPageActions extends HeaderPage {

    public boolean checkAppIconDisplayed(){
        return appIcon.isDisplayed();
    }

    public void moveMouseToAppIcon(){
        Actions actions = new Actions(driver);
        actions.moveToElement(appIcon).perform();
    }

}
