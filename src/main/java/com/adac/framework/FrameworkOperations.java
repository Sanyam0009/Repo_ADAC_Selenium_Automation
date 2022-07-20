package com.adac.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class FrameworkOperations {
    WebDriver driver = BrowserManager.getDriver();

    public void switchToFrameAfterWait(String frameName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameName)));
    }

    public void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

    public String dateTimeStampGenerator(){
        Date date = new Date();
        return "_" + date.toString().replace(":","").replace(" ","");

    }
}
