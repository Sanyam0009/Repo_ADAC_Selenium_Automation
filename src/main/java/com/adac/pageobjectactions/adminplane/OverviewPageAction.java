package com.adac.pageobjectactions.adminplane;

import com.adac.pageobjects.adminplane.OverviewPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OverviewPageAction extends OverviewPage {

    public void clickAddTeamButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addTeamButton).perform();
        addTeamButton.click();
    }
}
