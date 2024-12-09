package com.blogcms.tests;

import com.blogcms.base.BaseTest;
import com.blogcms.constants.TestConstants;
import com.blogcms.factory.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTest extends BaseTest {
    
    @Test(description = "Verify signout functionality")
    public void verify_signout() {
        navigateToBaseUrl();
        
        // Login
        pages.getLoginPage()
             .enterEmail(config.getValidEmail())
             .enterPassword(config.getValidPassword())
             .clickCheckbox()
             .clickSubmitButton();

        // Logout
        pages.getDashboardPage()
             .clickLogout();

        // Verify
        String actualHeading = pages.getLoginPage().getSignInHeading();
        Assert.assertEquals(actualHeading, TestConstants.SIGN_IN_TITLE,
                TestConstants.SIGN_OUT_ERROR);
    }
}
