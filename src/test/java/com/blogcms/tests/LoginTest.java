package com.blogcms.tests;

import com.blogcms.base.BaseTest;
import com.blogcms.pages.DashboardPage;
import com.blogcms.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify login with valid credentials")
    public void verify_login_with_valid_data() {
        navigateToBaseUrl();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(config.getValidEmail());
        loginPage.enterPassword(config.getValidPassword());
        loginPage.clickCheckbox();
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        String actualHeading = dashboardPage.getHeading();
        String expectedHeading = "Dashboard";

        Assert.assertEquals(actualHeading, expectedHeading,
                "The heading does not match. Expected: " + expectedHeading + ", but got: " + actualHeading);
    }

    @Test(description = "Verify login with invalid credentials")
    public void verify_login_with_invalid_data() {
        navigateToBaseUrl();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(config.getInvalidEmail());
        loginPage.enterPassword(config.getInvalidPassword());
        loginPage.clickCheckbox();
        loginPage.clickSubmitButton();
        boolean isInvalidCredentialsLabelPresent = loginPage.getInvalidCredentialsLabel();
        if(isInvalidCredentialsLabelPresent) {
            Assert.assertTrue(true, "Login should not succeed with invalid credentials");
        } else {
            Assert.fail("User logged in with invalid credentials");
        }
    }
}
