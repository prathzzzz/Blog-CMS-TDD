package com.blogcms.listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.blogcms.base.BaseTest;
import com.blogcms.utils.ExtentReportManager;
import com.blogcms.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    
    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
        ExtentReportManager.getTest().info(
            MarkupHelper.createLabel("Test Started: " + result.getMethod().getMethodName(), ExtentColor.BLUE));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, 
            MarkupHelper.createLabel("Test Passed: " + result.getMethod().getMethodName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL, 
            MarkupHelper.createLabel("Test Failed: " + result.getMethod().getMethodName(), ExtentColor.RED));
        ExtentReportManager.getTest().fail(result.getThrowable());
        
        try {
            Object testClass = result.getInstance();
            WebDriver driver = ((BaseTest) testClass).getDriver();
            
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver);
            if (screenshotPath != null) {
                ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
            }
        } catch (Exception e) {
            ExtentReportManager.getTest().info("Could not capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP, 
            MarkupHelper.createLabel("Test Skipped: " + result.getMethod().getMethodName(), ExtentColor.YELLOW));
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReports();
    }
} 