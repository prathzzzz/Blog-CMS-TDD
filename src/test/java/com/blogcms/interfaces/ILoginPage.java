package com.blogcms.interfaces;

public interface ILoginPage {
    void enterEmail(String email);
    void enterPassword(String password);
    void clickCheckbox();
    void clickSubmitButton();
    boolean getInvalidCredentialsLabel();
}
