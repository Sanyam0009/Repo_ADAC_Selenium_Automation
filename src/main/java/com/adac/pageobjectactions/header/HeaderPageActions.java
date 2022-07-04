package com.adac.pageobjectactions.header;

import com.adac.pageobjects.header.HeaderPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;

public class HeaderPageActions extends HeaderPage {
    public void moveMousetoAppIcon(){
        Actions actions = new Actions(driver);
        actions.moveToElement(appIcon).perform();
    }

}
