package com.blogcms.base;

import com.blogcms.utils.WebElementUtils;
import com.blogcms.utils.WebElementUtilsFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected final WebDriver driver;
    protected final WebElementUtils elementUtils;

    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
        this.elementUtils = WebElementUtilsFactory.getInstance(driver);
        PageFactory.initElements(driver, this);
    }
} 