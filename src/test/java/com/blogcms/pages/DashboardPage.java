package com.blogcms.pages;

import com.blogcms.base.BasePage;
import com.blogcms.constants.TestConstants;
import com.blogcms.interfaces.IDashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.blogcms.locators.DashboardLocators.*;

public class DashboardPage extends BasePage implements IDashboardPage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = DASHBOARD_HEADING)
    private WebElement labelDashboardHeading;

    @FindBy(xpath = LOGOUT_BUTTON) private WebElement buttonLogout;

    @FindBy(xpath = CATEGORIES_LINK) private WebElement linkCategory;

    @FindBy(xpath = TAGS_LINK) private WebElement linkTags;

    @Override
    public String getHeading() {
        return elementUtils.getText(labelDashboardHeading);
    }

    @Override
    public void clickLogout() {
        elementUtils.click(buttonLogout);
    }

    @Override
    public boolean isDashboardDisplayed() {
        return elementUtils.getText(labelDashboardHeading)
                .equals(TestConstants.DASHBOARD_TITLE);
    }

    @Override
    public void goToCategoriesPage() {
        elementUtils.click(linkCategory);
    }

    @Override
    public void goToTagsPage() {
        elementUtils.click(linkTags);
    }
}