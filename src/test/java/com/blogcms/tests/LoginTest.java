package com.blogcms.tests;

import com.blogcms.base.BaseTest;
import com.blogcms.pages.DashboardPage;
import com.blogcms.pages.LoginPage;
import com.blogcms.constants.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify login with valid credentials")
    public void verify_login_with_valid_data() {
        navigateToBaseUrl();
        
        pages.getLoginPage()
             .enterEmail(config.getValidEmail())
             .enterPassword(config.getValidPassword())
             .clickCheckbox()
             .clickSubmitButton();

        Assert.assertEquals(pages.getDashboardPage().getHeading(), 
                          TestConstants.DASHBOARD_TITLE,
                          TestConstants.HEADING_MISMATCH_ERROR);
    }

    @Test(description = "Verify login with invalid credentials")
    public void verify_login_with_invalid_data() {
        navigateToBaseUrl();
        
        pages.getLoginPage()
             .enterEmail(config.getInvalidEmail())
             .enterPassword(config.getInvalidPassword())
             .clickSubmitButton();

        Assert.assertTrue(pages.getLoginPage().getInvalidCredentialsLabel(),
                        TestConstants.INVALID_CREDENTIALS_NOT_DISPLAYED);
    }
}
