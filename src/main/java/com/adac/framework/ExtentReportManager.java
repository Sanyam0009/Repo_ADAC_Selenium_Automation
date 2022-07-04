package com.adac.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExtentReportManager {
    static WebDriver driver;

    public static ExtentReports getExtentReport(){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport/test.html");
        extentSparkReporter.config().setEncoding("UTF-8");
        extentSparkReporter.config().setReportName("ADAC_Testing");
        extentSparkReporter.config().setDocumentTitle("ADAD_Testng_Report");

        ExtentReports extentReports = new ExtentReports();
        extentReports.setSystemInfo("Created By", "Sanyam");
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getScreenShot(String methodName) throws IOException {
        Date date = new Date();
        driver = BrowserManager.getDriver();
        String fileName = methodName + "_SC_" + date.toString().replace(":","").replace(" ","") + ".png";
        String directory = System.getProperty("user.dir") + "/Screenshots/";
        new File(directory).mkdir();
        String target = directory + fileName;
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File(target));
        return target;

    }
}
