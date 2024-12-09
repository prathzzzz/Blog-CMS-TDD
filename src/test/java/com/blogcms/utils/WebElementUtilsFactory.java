package com.blogcms.utils;

import org.openqa.selenium.WebDriver;

public class WebElementUtilsFactory {
    private static final ThreadLocal<WebElementUtils> elementUtils = new ThreadLocal<>();

    public static WebElementUtils getInstance(WebDriver driver) {
        if (elementUtils.get() == null) {
            elementUtils.set(new WebElementUtils(driver));
        }
        return elementUtils.get();
    }

    public static void removeInstance() {
        elementUtils.remove();
    }
} 