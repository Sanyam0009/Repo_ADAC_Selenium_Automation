package com.adac.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameworkOperations {
    WebDriver driver = BrowserManager.getDriver();
    public void switchToFrameAfterWait(String frameName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameName)));
        //driver.switchTo().frame("datahub");
    }
}
