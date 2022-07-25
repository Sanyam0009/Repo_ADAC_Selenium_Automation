package com.adac.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ExtentReportController implements ITestListener {
    ExtentReports extentReports = ExtentReportManager.getExtentReport();
    ExtentTest extentTest;

    ThreadLocal<ExtentTest> extentTestTL = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extentReports.createTest(result.getTestClass().getName() + "==>" + result.getMethod().getMethodName());
        extentTestTL.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String logText = "<b>" + result.getMethod().getMethodName() + " - Passed Successfully <b>";
        Markup markupLogText = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTestTL.get().pass(markupLogText);
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ExtentReportManager.getScreenShotAsBase64();
        String logText = "<b>" + result.getMethod().getMethodName() + " - Test Failed <b>";
        Markup markupLogText = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTestTL.get().fail(markupLogText);

        extentTestTL.get().fail("<details> <summary> <b> <font color='red'> Assertion Failed  - Click here to see details </summary> </b> </font>" +
                result.getThrowable().toString().replace(",","<br>").replace("Expected","<b>Expected</b>").replace("Actual","<b>Actual</b>") + "</derails> \n");

        String errorLog = Arrays.toString(result.getThrowable().getStackTrace());
        extentTestTL.get().fail("<details> <summary> <b> <font color='red'> Exception occurred - Click here to see details </summary> </b> </font>" +
                errorLog.replace(",", "<br>") + "</derails> \n");

        extentTestTL.get().fail("<b><font color='red'> Screenshot of Failure </font></b>", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "<b>" + result.getMethod().getMethodName() + " - Test Skipped <b>";
        Markup markupLogText = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTestTL.get().skip(markupLogText);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}