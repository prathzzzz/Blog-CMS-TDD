package com.blogcms.factory;

import com.blogcms.pages.CategoryPage;
import com.blogcms.pages.LoginPage;
import com.blogcms.pages.DashboardPage;
import com.blogcms.pages.TagPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private final WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CategoryPage categoryPage;
    private TagPage tagPage;
    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(driver);
        }
        return dashboardPage;
    }

    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage(driver);
        }
        return categoryPage;
    }

    public TagPage getTagPage() {
        if (tagPage == null) {
            tagPage = new TagPage(driver);
        }
        return tagPage;
    }
} 