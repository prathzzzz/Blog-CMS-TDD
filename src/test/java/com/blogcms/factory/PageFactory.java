package com.blogcms.factory;

import com.blogcms.pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private final WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public DashboardPage getDashboardPage() {
        return new DashboardPage(driver);
    }
} 