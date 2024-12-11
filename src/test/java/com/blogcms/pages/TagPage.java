package com.blogcms.pages;

import com.blogcms.base.BasePage;
import com.blogcms.interfaces.ITagPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.blogcms.locators.TagLocators.*;

public class TagPage extends BasePage implements ITagPage {

    @FindBy(xpath = CREATE_NEW_TAG)
    private WebElement buttonCreateNewTag;

    @FindBy(xpath = TAG_NAME_INPUT)
    private WebElement inputTagName;

    @FindBy(xpath = CREATE_TAG_BUTTON)
    private WebElement buttonCreateTag;


    public TagPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TagPage clickCreateNewTag() {
        elementUtils.click(buttonCreateNewTag);
        return this;
    }

    @Override
    public TagPage setTagName(String name) {
        elementUtils.sendKeys(inputTagName, name);
        return this;
    }

    @Override
    public void clickCreateTag() {
        elementUtils.click(buttonCreateTag);

    }



}
