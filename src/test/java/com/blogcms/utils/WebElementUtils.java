package com.blogcms.utils;

import com.blogcms.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebElementUtils {
    private static final Logger logger = LogManager.getLogger(WebElementUtils.class);
    private static final int TIMEOUT = Configuration.getInstance().getExplicitTimeout();
    private final WebDriver driver;

    public WebElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element) {
        logger.debug("Waiting for element to be visible");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        logger.debug("Waiting for element to be clickable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        logger.debug("Attempting to click element");
        waitForElementToBeClickable(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        logger.debug("Attempting to send keys: {}", text);
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        logger.debug("Attempting to get text from element");
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
} 