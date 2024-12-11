package com.blogcms.utils;

import com.blogcms.constants.TestConstants;
import com.blogcms.exceptions.ElementActionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementUtils {
    private static final Logger logger = LogManager.getLogger(WebElementUtils.class);
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebElementUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(TestConstants.DEFAULT_TIMEOUT_SECONDS));
    }

    public void waitForElementToBeVisible(WebElement element) {
        try {
            logger.debug("Waiting for element to be visible: {}", element);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new ElementActionException("Element did not become visible", e);
        }
    }

    public void click(WebElement element) {
        try {
            logger.debug("Clicking element: {}", element);
            waitForElementToBeClickable(element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            throw new ElementActionException("Element click was intercepted", e);
        } catch (StaleElementReferenceException e) {
            throw new ElementActionException("Element is stale", e);
        }
    }

    public void sendKeys(WebElement element, String text) {
        try {
            logger.debug("Sending keys to element: {}", element);
            waitForElementToBeVisible(element);
            element.clear();
            element.sendKeys(text);
        } catch (InvalidElementStateException e) {
            throw new ElementActionException("Element is not in a state to accept text", e);
        }
    }

    public String getText(WebElement element) {
        try {
            logger.debug("Getting text from element: {}", element);
            waitForElementToBeVisible(element);
            return element.getText();
        } catch (StaleElementReferenceException e) {
            throw new ElementActionException("Element is stale while getting text", e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return wait.until(driver -> {
                try {
                    return element.isDisplayed();
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            });
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new ElementActionException("Element did not become clickable", e);
        }
    }
    public void waitForElementValue(WebElement element, String text) {
        try {
            logger.debug("Waiting for element to have a value: {}", element);
            wait.until(driver -> !element.getAttribute("value").isEmpty());
        } catch (TimeoutException e) {
            throw new ElementActionException("Element value was not populated within timeout", e);
        }
    }
}

