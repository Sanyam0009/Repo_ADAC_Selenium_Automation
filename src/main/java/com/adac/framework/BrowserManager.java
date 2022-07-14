package com.adac.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserManager {

    private static WebDriver driver;
    private static int implicitlyWaitTimeout = 2;
    String appUrl="http://www.adac-dev-kyndryl.com/";

    /*##########################################################
    MethodName = driverManager;
    Parameter = driver name (chrome or firefox or edge);
    return type = void;
    description = To Create and set desired driver;
    Created By = Sanyam Choudhary
    Created On = 25-June-2022
     ###########################################################*/
    protected  void driverManager(String driverName){
        if(driverName.trim().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(appUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitTimeout));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implicitlyWaitTimeout));
            driver.manage().window().maximize();
        }else if(driverName.trim().equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(appUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitTimeout));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implicitlyWaitTimeout));
            driver.manage().window().maximize();

        }else if(driverName.trim().equalsIgnoreCase("edge")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(appUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitTimeout));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implicitlyWaitTimeout));
            driver.manage().window().maximize();
        }

    }
    /*##########################################################
    MethodName = getDriver;
    Parameter = NA;
    return type = WebDriver;
    description = To get the WebDriver, Created by method driverManager(String driverName);
    Created By = Sanyam Choudhary
    Created On = 25-June-2022
     ###########################################################*/
    public static WebDriver getDriver(){
        return driver;
    }



}
