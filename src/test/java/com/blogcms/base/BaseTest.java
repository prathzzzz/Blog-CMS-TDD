package com.blogcms.base;

import com.blogcms.config.Configuration;
import com.blogcms.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected Configuration config;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        config = Configuration.getInstance();
        driver = DriverManager.getDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            DriverManager.removeDriver();
        }
    }

    protected void navigateToBaseUrl() {
        driver.get(config.getBaseUrl());
    }

    public WebDriver getDriver() {
        return driver;
    }
}