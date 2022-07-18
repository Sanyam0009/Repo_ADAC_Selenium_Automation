package com.adac.pageobjectactions.adminplane;

import com.adac.pageobjects.adminplane.TeamsPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class TeamsPageActions extends TeamsPage {
    public void createTeam(String teamName, String roleName, String description) throws InterruptedException {
        teamNameTextBox.sendKeys(teamName);
        Thread.sleep(7000);
        rolesDropdown.click();
        roleDropdownOption(roleName).click();
        teamDescriptiontextArea.sendKeys(description);
        saveButton.click();
    }
}
