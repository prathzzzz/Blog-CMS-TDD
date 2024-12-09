package com.blogcms.interfaces;

import com.blogcms.pages.LoginPage;

public interface ILoginPage {
    LoginPage enterEmail(String email);
    LoginPage enterPassword(String password);
    LoginPage clickCheckbox();
    void clickSubmitButton();
    boolean getInvalidCredentialsLabel();
    String getSignInHeading();
}
