package com.blogcms.base;

import com.blogcms.utils.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected WebElementUtils elementUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new WebElementUtils(driver);
        PageFactory.initElements(driver, this);
    }
} 