package com.blogcms.pages;

import com.blogcms.base.BasePage;
import com.blogcms.interfaces.ILoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.blogcms.locators.LoginLocators.*;

public class LoginPage extends BasePage implements ILoginPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = EMAIL_INPUT)
    private WebElement inputEmail;

    @FindBy(xpath = PASSWORD_INPUT)
    private WebElement inputPassword;

    @FindBy(xpath = REMEMBER_ME_CHECKBOX)
    private WebElement checkboxRememberMe;

    @FindBy(xpath = SUBMIT_BUTTON)
    private WebElement buttonSubmit;

    @FindBy(xpath = INVALID_CREDENTIALS_LABEL)
    private WebElement labelInvalidCredentials;

    @FindBy(xpath = SIGN_IN_LABEL)
    private WebElement labelSignIn;

    @Override
    public LoginPage enterEmail(String email) {
        elementUtils.sendKeys(inputEmail, email);
        return this;
    }

    @Override
    public LoginPage enterPassword(String password) {
        elementUtils.sendKeys(inputPassword, password);
        return this;
    }

    @Override
    public LoginPage clickCheckbox() {
        elementUtils.click(checkboxRememberMe);
        return this;
    }

    @Override
    public DashboardPage clickSubmitButton() {
        elementUtils.click(buttonSubmit);
        return new DashboardPage(driver);
    }

    @Override
    public boolean getInvalidCredentialsLabel() {
        return elementUtils.isElementDisplayed(labelInvalidCredentials);
    }

    @Override
    public String getSignInHeading() {
        return elementUtils.getText(labelSignIn);
    }
}
