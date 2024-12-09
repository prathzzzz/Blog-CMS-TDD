package com.blogcms.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static String reportPath;

    public static void initReports() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            reportPath = System.getProperty("user.dir") + "/test-output/reports/TestReport_" + timestamp + ".html";
            
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            
            // Configure report appearance
            spark.config().setDocumentTitle("Test Execution Report");
            spark.config().setReportName("Blog CMS Test Report");
            spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
            
            extent.attachReporter(spark);
            
            // Add system info
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", "Chrome"); // You can make this dynamic
        }
    }

    public static void createTest(String testName) {
        test.set(extent.createTest(testName));
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
            openReport();
        }
    }

    private static void openReport() {
        try {
            File reportFile = new File(reportPath);
            if (reportFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            }
        } catch (IOException e) {
            System.out.println("Could not open report automatically: " + e.getMessage());
        }
    }
} 