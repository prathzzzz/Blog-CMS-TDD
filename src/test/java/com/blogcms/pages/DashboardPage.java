package com.blogcms.pages;

import com.blogcms.base.BasePage;
import com.blogcms.interfaces.IDashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.blogcms.locators.DashboardPage.*;

public class DashboardPage extends BasePage implements IDashboardPage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = DASHBOARD_HEADING)
    private WebElement labelDashboardHeading;

    @FindBy(xpath = LOGOUT_BUTTON) private WebElement buttonLogout;

    @Override
    public String getHeading() {
        return elementUtils.getText(labelDashboardHeading);
    }

    @Override
    public void clickLogout() {
        elementUtils.click(buttonLogout);
    }
}
