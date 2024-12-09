package com.blogcms.locators;

public class LoginPage {
    public static final String EMAIL_INPUT = "//input[@id='data.email']";
    public static final String PASSWORD_INPUT = "//input[@id='data.password']";
    public static final String REMEMBER_ME_CHECKBOX = "//input[@id='data.remember']";
    public static final String SUBMIT_BUTTON = "//span[normalize-space()='Sign in']";
    public static final String INVALID_CREDENTIALS_LABEL = "//p[contains(.,'These credentials do not match our records.')]";
    public static final String SIGN_IN_LABEL = "//h1[normalize-space()='Sign in']";
}
