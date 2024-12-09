package com.blogcms.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            driver.set(createDriver(browser));
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    private static WebDriver createDriver(String browser) {
        return switch (browser.toLowerCase()) {
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "chrome" -> new ChromeDriver();
            default -> throw new RuntimeException("Unsupported browser type: " + browser);
        };
    }

    public static void removeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
} 