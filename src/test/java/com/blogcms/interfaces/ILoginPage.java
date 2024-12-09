package com.blogcms.interfaces;

import com.blogcms.pages.LoginPage;
import com.blogcms.pages.DashboardPage;

public interface ILoginPage {
    LoginPage enterEmail(String email);
    LoginPage enterPassword(String password);
    LoginPage clickCheckbox();
    DashboardPage clickSubmitButton();
    boolean getInvalidCredentialsLabel();
    String getSignInHeading();
}
