package com.blogcms.pages;

import com.blogcms.base.BasePage;
import com.blogcms.interfaces.ILoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.blogcms.locators.LoginPage.*;

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

    @Override
    public void enterEmail(String email) {
        elementUtils.sendKeys(inputEmail, email);
    }

    @Override
    public void enterPassword(String password) {
        elementUtils.sendKeys(inputPassword, password);
    }

    @Override
    public void clickCheckbox() {
        elementUtils.click(checkboxRememberMe);
    }

    @Override
    public void clickSubmitButton() {
        elementUtils.click(buttonSubmit);
    }

    @Override
    public boolean getInvalidCredentialsLabel() {
        return elementUtils.isElementDisplayed(labelInvalidCredentials);
    }

}
